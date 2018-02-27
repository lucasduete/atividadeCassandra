package io.github.lucasduete.atividadeCassandra.model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.Objects;

@UDT(keyspace = "atividadeCassandra", name = "telefone")
public class Telefone {

    private int ddd;
    private long numero;

    public Telefone() {

    }

    public Telefone(int ddd, long numero) {

        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return getDdd() == telefone.getDdd() &&
                getNumero() == telefone.getNumero();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDdd(), getNumero());
    }

    @Override
    public String toString() {

        return "Telefone{" +
                "ddd=" + ddd +
                ", numero=" + numero +
                '}';
    }
}
