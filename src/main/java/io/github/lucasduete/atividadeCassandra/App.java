package io.github.lucasduete.atividadeCassandra;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import io.github.lucasduete.atividadeCassandra.factory.Conexao;
import io.github.lucasduete.atividadeCassandra.model.Telefone;
import io.github.lucasduete.atividadeCassandra.model.Usuario;

public class App {

    public static void main(String[] args) {

        Session session = Conexao.getConnection();



        Usuario user = new Usuario(
                1,"Lucas"
        );

        user.addTelefone("Casa", new Telefone(
                88, 96712803
        ));

        user.addTelefone("Pessoal", new Telefone(
                88, 99681997
        ));

        mapper.save(user);

        Usuario usuario = mapper.get(1);
        mapper.delete(usuario);

        Conexao.closeConnection();
        //session.getCluster().close();
    }
}
