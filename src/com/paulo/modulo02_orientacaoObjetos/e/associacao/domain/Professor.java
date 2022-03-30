package com.paulo.modulo02_orientacaoObjetos.e.associacao.domain;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String especialidade;
    private List<Seminario> seminarios;

    {
        this.seminarios = new ArrayList<Seminario>();
    }

    public Professor(){}

    public Professor(String nome, String especialidade){
        this.nome = nome;
        this.especialidade = especialidade;
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

    public List<Seminario> getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(List<Seminario> seminarios) {
        this.seminarios = seminarios;
    }

    public void ministrar(Seminario seminario){
        seminarios.add(seminario);
    }

    public void finalizarSeminario(Seminario seminario){
        seminarios.remove(seminario);
    }

    public String toString(){
        StringBuilder professor = new StringBuilder();
        professor.append(String.format("Professor: %s, Especialidade: %s\n", nome, especialidade));
        professor.append("Seminários: ");
        if(seminarios.isEmpty()){
            professor.append("Nenhum.");
        }else{
            professor.append("\n");
            for(Seminario seminario : seminarios){
                professor.append(seminario.descreveSeminario()).append("\n");
                professor.append("-----------");
            }
        }
        return professor.toString();
    }
}
