package com.paulo.modulo02_orientacaoObjetos.e.associacao.domain;

import java.util.ArrayList;
import java.util.List;

public class Seminario {
    private String titulo;
    private Professor professor;
    private String data;
    private Local local;
    private boolean status;
    private List<Aluno> alunos;

    {
        alunos = new ArrayList<Aluno>();
        status = true;
    }

    public Seminario() {}

    public Seminario(String titulo, String data, Local local) {
        this.titulo = titulo;
        this.data = data;
        this.local = local;
    }

    public Seminario(String titulo, String data, Local local, Professor professor){
        this(titulo, data, local);
        this.professor = professor;
        professor.ministrar(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public boolean addAluno(Aluno aluno) {
        if(alunos.contains(aluno)){
            System.out.printf("Aluno %s já está matriculado neste evento.\n", aluno.getNome());
            return false;
        }
        alunos.add(aluno);
        return true;
    }

    public boolean removerAluno(Aluno aluno){
        return alunos.remove(aluno);
    }

    public String toString(){
        return "Seminário: " + titulo + "\n" +
               "Status: " + (status ? "Ativo" : "Inativo") + "\n" +
               "Professor: " + (professor != null ? professor.getNome() : "Não definido.") + "\n" +
               "Data: " + data + "\n" +
               "Alunos: " + alunos.size() + "\n" +
               "Endereço: " + local;
    }

    public String descreveSeminario(){
        return "Descrição: " + titulo + "\n" +
               "Data: " + data + "\n" +
               "Endereço: " + local;
    }
}
