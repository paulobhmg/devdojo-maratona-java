package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.Gerente;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.Vendedor;

public class A093_Polimorfismo {
    public static void main(String[] args) {
        Gerente paulo = new Gerente("Paulo", 8390);
        Vendedor vendedor = new Vendedor("Pedro", 3500);
        paulo.setComissao(0.1);
        vendedor.setComissao(0.03);
        paulo.imprime();
        vendedor.imprime();
        System.out.println("------------------------------");

        paulo.contratar(vendedor);
        vendedor.imprime();
        paulo.imprime();
        System.out.println("------------------------------");

        paulo.demitir(vendedor);
        vendedor.imprime();
        paulo.imprime();
        paulo.demitir(vendedor);
        System.out.println("------------------------------");

        paulo.contratar(vendedor);
        vendedor.vender(100);
        vendedor.imprime();
        paulo.imprime();

    }

}
