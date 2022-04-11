package com.paulo.modulo02_orientacaoObjetos.e_associacao.domain;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Seminario> seminarios;

    {
        seminarios = new ArrayList<Seminario>();
    }

    public Aluno(){}

    public Aluno(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Seminario> getSeminarios() {
        return seminarios;
    }

    public void participarDeSeminario(Seminario seminario){
        if(seminario.addAluno(this)) {
            seminarios.add(seminario);
        }
    }

    public void sairDoSeminario(Seminario seminario){
        if(!seminario.removerAluno(this)){
            System.out.printf("Aluno %s não está inscrito no seminário %s.\n", nome, seminario.getTitulo());
        }else{
            seminarios.remove(seminario);
        }
    }
    
    public String toString(){
        StringBuilder aluno = new StringBuilder();
        aluno.append(String.format("Aluno: %s\n", nome));
        aluno.append("Seminários: ");
        if(seminarios.isEmpty()){
            aluno.append("Nenhum.");
        }else{
            aluno.append("\n");
            for(Seminario seminario : seminarios){
                aluno.append(seminario.descreveSeminario()).append("\n");
                aluno.append("-----------");
            }
        }
        return aluno.toString();
    }
}
