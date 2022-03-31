package com.paulo.modulo02_orientacaoObjetos.f.heranca.domain;

public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;

    public Endereco() {}

    public Endereco(String logradouro, String numero, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String toString(){
        return String.format("%s, n° %s, bairro %s.", logradouro, numero, bairro);
    }
}
