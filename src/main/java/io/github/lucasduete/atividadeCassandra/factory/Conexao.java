package io.github.lucasduete.atividadeCassandra.factory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Conexao {

    private static Cluster cluster = null;

    public static Session getConnection() {
        cluster = Cluster.builder()
                            .addContactPoint("172.17.0.2")
                            .withPort(9042)
                                .build();

        Session session = cluster.connect();

        return session;
    }

    public static void closeConnection() {
        cluster.close();
    }
}
