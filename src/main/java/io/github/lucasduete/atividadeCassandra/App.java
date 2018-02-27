package io.github.lucasduete.atividadeCassandra;

import com.datastax.driver.core.Session;
import io.github.lucasduete.atividadeCassandra.dao.cassandra.UsuarioDaoCassandra;
import io.github.lucasduete.atividadeCassandra.dao.interfaces.UsuarioDaoInterface;
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

        Usuario user2 = new Usuario(
                2,"Jose"
        );

        user2.addTelefone("Personal", new Telefone(
                83, 88739924
        ));

        UsuarioDaoInterface userDao = new UsuarioDaoCassandra();
        userDao.salvar(user);
        userDao.salvar(user2);

        System.out.println(userDao.listar());

        userDao.remover(1);
        userDao.remover(2);

        System.out.println(userDao.buscar(1));
    }
}
