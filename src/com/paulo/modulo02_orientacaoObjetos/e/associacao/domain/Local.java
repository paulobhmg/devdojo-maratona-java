package com.paulo.modulo02_orientacaoObjetos.e.associacao.domain;

public class Local {
    private String descricao;
    private String logradouro;
    private int numero;
    private String bairro;

    public Local(){}

    public Local(String descricao, String logradouro, int numero, String bairro) {
        this.descricao = descricao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String toString(){
        return descricao + " - " + "Endereço: " + logradouro + ", " + numero + ", bairro " + bairro + ".";
    }
}
