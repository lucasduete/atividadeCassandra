package io.github.lucasduete.atividadeCassandra.model;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.Map;
import java.util.Objects;

@Table(keyspace = "atividadeCassandra", name = "usuario")
public class Usuario {

    @PartitionKey
    private int id;
    private String nome;
    @Frozen
    private Map<String,Telefone> telefones;

    public Usuario() {

    }

    public Usuario(int id, String nome, Map<String, Telefone> telefones) {

        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Map<String, Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(String nome, Telefone telefone) {

        telefones.put(nome, telefone);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getId() == usuario.getId() &&
                Objects.equals(getNome(), usuario.getNome()) &&
                Objects.equals(getTelefones(), usuario.getTelefones());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNome(), getTelefones());
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
