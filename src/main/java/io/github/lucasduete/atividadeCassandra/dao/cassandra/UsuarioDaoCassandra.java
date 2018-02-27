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

    private final Session session;

    public UsuarioDaoCassandra() {
        session = Conexao.getConnection();
    }

    @Override
    public boolean salvar(Usuario usuario) {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.save(usuario);
        Conexao.closeConnection();

        return true;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.save(usuario);
        Conexao.closeConnection();

        return true;
    }

    @Override
    public boolean remover(Usuario usuario) {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        mapper.delete(usuario);
        Conexao.closeConnection();

        return true;
    }

    @Override
    public boolean remover(int idUsuario) {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        Usuario user = mapper.get(idUsuario);
        mapper.delete(user);
        Conexao.closeConnection();

        return true;
    }

    @Override
    public List<Usuario> listar() {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);
        PreparedStatement stmt = session.prepare("SELECT * FROM Pessoa;");

        Result<Usuario> result = mapper.map(session.execute(stmt.bind()));
        List<Usuario> usuarios = new ArrayList<>();

        for (Usuario user: result) {
            usuarios.add(user);
        }

        return usuarios;
    }

    @Override
    public Usuario buscar(int idUsuario) {
        MappingManager mappingManager = new MappingManager(session);
        Mapper<Usuario> mapper = mappingManager.mapper(Usuario.class);

        Usuario user = mapper.get(idUsuario);
        Conexao.closeConnection();

        return user;
    }
}
