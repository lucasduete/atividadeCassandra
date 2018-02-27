package io.github.lucasduete.atividadeCassandra.factory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Conexao {

    private static Cluster cluster = null;

    public static Session getConnection() {
        try {
            cluster = Cluster.builder()
                                .addContactPoint("127.17.0.2")
                                .withPort(9042)
                                    .build();

            Session session = cluster.connect("atividadeCassandra");

            return session;
        } finally {
            cluster.close();
        }
    }
}
