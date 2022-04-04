package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.Gerente;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.Vendedor;

/* Quando falamos em polimorfismo, tratamos sobre as várias formas que um objeto pode ser referenciado. O polimorfismo,
   em sua essência, é utilizado quando há herança ou contratos entre interfaces.
   Um objeto é polimorfico quando pode ser referenciado tanto de sua classe de origem, quanto de sua classe genérica,
   sendo esta segunda uma classe Pai ou uma Interface, que fornece um contrato comum a todas as classes que a implementem.

   Sendo assim, é possível criar programas e relatórios genéricos, proporcionando economia de código, compartilhamento
   e reutilização de lógicas para diversos casos de uso. */
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
