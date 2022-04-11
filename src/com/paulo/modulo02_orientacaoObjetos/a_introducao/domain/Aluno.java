package com.paulo.modulo02_orientacaoObjetos.a_introducao.domain;

import java.util.Objects;

public class Aluno {
    int idade;
    String nome;
    char sexo;
    Professor professor;

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
