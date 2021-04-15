package org.jboss.fuse.tnb.product.cq.application;

import org.jboss.fuse.tnb.common.config.OpenshiftConfiguration;
import org.jboss.fuse.tnb.common.config.TestConfiguration;
import org.jboss.fuse.tnb.product.application.App;
import org.jboss.fuse.tnb.product.integration.IntegrationBuilder;
import org.jboss.fuse.tnb.product.integration.IntegrationGenerator;
import org.jboss.fuse.tnb.product.util.BuildRequest;
import org.jboss.fuse.tnb.product.util.Maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class QuarkusApp extends App {
    private static final Logger LOG = LoggerFactory.getLogger(QuarkusApp.class);

    public QuarkusApp(String name, IntegrationBuilder integrationBuilder, String... camelComponents) {
        super(name);
        LOG.info("Creating Camel Quarkus application project for integration {}", name);

        String extensions = Arrays.stream(camelComponents).map(c -> "camel-quarkus-" + c).collect(Collectors.joining(","));
        if (OpenshiftConfiguration.isOpenshift()) {
            extensions += ",openshift";
        }
        Maven.invoke(new BuildRequest.Builder()
            .withBaseDirectory(TestConfiguration.appLocation())
            .withGoals("io.quarkus:quarkus-maven-plugin:" + TestConfiguration.quarkusVersion() + ":create")
            .withProperties(Map.of(
                "projectGroupId", TestConfiguration.appGroupId(),
                "projectArtifactId", name,
                "extensions", extensions
            ))
            .build()
        );

        IntegrationGenerator.toFile(integrationBuilder, TestConfiguration.appLocation().resolve(name));

        BuildRequest.Builder requestBuilder = new BuildRequest.Builder()
            .withBaseDirectory(TestConfiguration.appLocation().resolve(name))
            .withGoals("clean", "package")
            .withProperties(Map.of(
                "skipTests", "true",
                "quarkus.native.container-build", "true"
            ));
        if (TestConfiguration.isQuarkusNative()) {
            requestBuilder.withProfiles("native");
        }

        LOG.info("Building {} application project ({})", name, TestConfiguration.isQuarkusNative() ? "native" : "JVM");
        Maven.invoke(requestBuilder.build());
    }
}
