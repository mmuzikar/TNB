package software.tnb.db.cassandra;

import software.tnb.common.service.ServiceFactory;
import software.tnb.db.cassandra.service.Cassandra;

public class TestClass {

    public static void main(String[] args) {
        ServiceFactory.createService(Cassandra.class, config -> config.cassandraMethod());
    }
}
