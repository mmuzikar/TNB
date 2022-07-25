package software.tnb.product.rp;

import software.tnb.common.config.TestConfiguration;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.auto.service.AutoService;

@AutoService(TestExecutionListener.class)
public class RPTestExecutionListener implements TestExecutionListener {

    private static final Logger LOG = LoggerFactory.getLogger(RPTestExecutionListener.class);

    private static String transformReportingName(String name) {
        return name.replace("()", "").replace("(", "{").replace(")", "}");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (!TestConfiguration.reportPortalEnabled()) {
            LOG.debug("RPLISTENER: Skipping");
            return;
        }

        LOG.debug("RPListener: execution started");

        if (testIdentifier.isTest()) {
            Attachments.startTestCase(transformReportingName(testIdentifier.getLegacyReportingName()));
        } else {
            testIdentifier.getSource().ifPresent(source -> {
                if (source instanceof ClassSource) {
                    Attachments.startTestClass(((ClassSource) source).getClassName());
                } else {
                    LOG.warn("Unknown test source type {}", source.getClass());
                }
            });
        }
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier,
        TestExecutionResult testExecutionResult) {
        if (!TestConfiguration.reportPortalEnabled()) {
            LOG.debug("RPLISTENER: Skipping");
            return;
        }

        LOG.debug("RPListener: execution finished");

        if (testIdentifier.isTest()) {
            Attachments.endTestCase(testExecutionResult.getThrowable().isPresent());
        } else {
            testIdentifier.getSource().ifPresent(source -> {
                if (source instanceof ClassSource) {
                    Attachments.endTestClass();
                } else {
                    LOG.warn("Unknown test source type {}", source.getClass());
                }
            });
        }
    }
}
