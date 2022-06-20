package com.paulo.modulo08_generics.domain;

public class Barco {
    private String modelo;

    public Barco() {}

    public Barco(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Barco{" + "modelo='" + modelo + '\'' + '}';
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
