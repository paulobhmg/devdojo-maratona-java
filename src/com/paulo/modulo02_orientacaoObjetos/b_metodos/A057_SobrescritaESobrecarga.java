package com.paulo.modulo02_orientacaoObjetos.b_metodos;

import com.paulo.modulo02_orientacaoObjetos.b_metodos.domain.Carro;

public class A057_SobrescritaESobrecarga {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Carro carro2 = new Carro();

        carro.init("T-Cross");
        System.out.println(carro);

        carro2.init2("T-Cross", "Cinza Fosco");
        System.out.println(carro2);

        // Método sobrecarregado
        carro.init("T-Cross", "Branco");
        System.out.println(carro);
    }
}
