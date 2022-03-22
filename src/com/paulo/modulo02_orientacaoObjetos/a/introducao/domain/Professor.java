package com.paulo.modulo02_orientacaoObjetos.a.introducao.domain;

public class Professor {
    private int codigo;
    private String nome;
    private String especialidade;

    public Professor(){}

    public Professor(int codigo, String nome, String especialidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String toString(){
        return String.format("%d, %s, %s", codigo, nome, especialidade);
    }
}
