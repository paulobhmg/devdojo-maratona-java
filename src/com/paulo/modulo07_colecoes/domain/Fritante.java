package com.paulo.modulo07_colecoes.domain;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Fritante {
    private Long id;
    private String nome;

    public Fritante(){}

    public Fritante(String nome){
        this.id = ThreadLocalRandom.current().nextLong();
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fritante{" + "id=" + id + ", nome='" + nome + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) return false;
        if(this == o) return true;
        return id.equals(((Fritante) o).getId());
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}
