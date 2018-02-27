package io.github.lucasduete.atividadeCassandra.dao.cassandra;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import io.github.lucasduete.atividadeCassandra.dao.interfaces.UsuarioDaoInterface;
import io.github.lucasduete.atividadeCassandra.factory.Conexao;
import io.github.lucasduete.atividadeCassandra.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoCassandra implements UsuarioDaoInterface {

    private Session session;

    public UsuarioDaoCassandra() {

    }

    @Override
    public boolean salvar(Usuario usuario) {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.save(usuario);

        Conexao.closeConnection();
        session.close();

        return true;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.save(usuario);

        Conexao.closeConnection();
        session.close();

        return true;
    }

    @Override
    public boolean remover(Usuario usuario) {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.delete(usuario);

        Conexao.closeConnection();
        session.close();

        return true;
    }

    @Override
    public boolean remover(int idUsuario) {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        Usuario user = mapper.get(idUsuario);
        mapper.delete(user);

        Conexao.closeConnection();
        session.close();

        return true;
    }

    @Override
    public List<Usuario> listar() {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);
        PreparedStatement stmt = session.prepare("SELECT * FROM Usuario;");

        Result<Usuario> result = mapper.map(session.execute(stmt.bind()));
        List<Usuario> usuarios = new ArrayList<>();

        for (Usuario user: result) {
            usuarios.add(user);
        }

        Conexao.closeConnection();
        session.close();

        return usuarios;
    }

    @Override
    public Usuario buscar(int idUsuario) {
        session = Conexao.getConnection();

        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        Usuario user = mapper.get(idUsuario);

        Conexao.closeConnection();
        session.close();

        return user;
    }
}
