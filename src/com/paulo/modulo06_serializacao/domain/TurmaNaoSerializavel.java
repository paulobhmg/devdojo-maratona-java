package com.paulo.modulo06_serializacao.domain;

public class TurmaNaoSerializavel {
    private String nome;

    public TurmaNaoSerializavel() {}

    public TurmaNaoSerializavel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TurmaNaoSerializavel{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
