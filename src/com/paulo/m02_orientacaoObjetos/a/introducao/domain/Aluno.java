package com.paulo.m02_orientacaoObjetos.a.introducao.domain;

import java.util.Objects;

public class Aluno {
    private int idade;
    private String nome;
    private char sexo;
    private Professor professor;

    public Aluno() {}

    public Aluno(int idade, String nome, char sexo){
        this.idade = idade;
        this.nome = nome;
        this.sexo = sexo;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public char getSexo(){
        return sexo;
    }

    public String toString(){
        return String.format(
             "Nome: %s, idade: %d, sexo: %s \nProfessor: %s",
                nome, idade, sexo == 'M' ? "Masculino" : "Feminino",
                Objects.isNull(professor) ? "Nenhum" : professor
        );
    }
}
