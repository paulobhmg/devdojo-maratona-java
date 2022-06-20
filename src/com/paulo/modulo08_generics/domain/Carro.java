package com.paulo.modulo08_generics.domain;

public class Carro {
    private String modelo;

    public Carro() {}

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro{" + "modelo='" + modelo + '\'' + '}';
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
