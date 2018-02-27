package io.github.lucasduete.atividadeCassandra.dao.interfaces;

import io.github.lucasduete.atividadeCassandra.model.Usuario;

import java.util.List;

public interface UsuarioDaoInterface {

    public boolean salvar(Usuario usuario);
    public boolean atualizar(Usuario usuario);
    public boolean remover(Usuario usuario);
    public boolean remover(int idUsuario);
    public List<Usuario> listar();
    public Usuario buscar(int idUsuario);
}
