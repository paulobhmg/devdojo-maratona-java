package com.paulo.modulo07_colecoes.domain;

import java.util.Objects;

public class Smartphone {
    private String serialNumber;
    private String model;

    public Smartphone() { }

    public Smartphone(String serialNumber, String model) {
        this.serialNumber = serialNumber;
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "{" +"serial='" + serialNumber + '\'' + ", model='" + model + '\'' + '}';
    }

    /* Existem algumas regras para o método equals:
       1 - Reflexivo: x.equals(x) deve ser true para tudo que for diferente de null;
       2 - Simétrico: para x e y diferentes de null, se x.equals(y) == true, logo, y.equals(x) == true;
       3 - Transitividade: para x, y, z diferentes de null, se x.equals(y) e x.equals(z), logo, y.equals(z) == true;
       4 - Coesão: para x diferente de null, x.equals(null) deve retornar false;exivo e consistente: x. */
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) return false;
        if(this == obj) return true;
        return Objects.nonNull(serialNumber) && Objects.equals(serialNumber, ((Smartphone) obj).serialNumber);
    }

    public int hashCode(){
        return serialNumber == null ? 0 : serialNumber.hashCode();
    }
}
