package com.paulo.modulo02_orientacaoObjetos.b.metodos;

import com.paulo.modulo02_orientacaoObjetos.b.metodos.domain.Trator;

public class A059_ConstrutoresESobrecarga {
    public static void main(String[] args) {
        Trator trator1 = new Trator();
        Trator trator2 = new Trator("Tratorzão");
        Trator trator3 = new Trator("Trator de fazenda", 2020);

        System.out.println(trator1);
        System.out.println(trator2);
        System.out.println(trator3);
    }
}
