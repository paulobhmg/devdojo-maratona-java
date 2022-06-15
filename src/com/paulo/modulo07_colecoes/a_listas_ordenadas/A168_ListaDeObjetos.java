package com.paulo.modulo07_colecoes.a_listas_ordenadas;

import com.paulo.modulo07_colecoes.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class A168_ListaDeObjetos {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone("123", "Galaxy S21");
        Smartphone phone2 = new Smartphone("1", "Iphone 12");
        Smartphone phone3 = new Smartphone("12", "Alcatel");
        Smartphone phone4 = new Smartphone("12345", "Moto G20");
        Smartphone phone5 = new Smartphone("1234", "LG K11");

        List<Smartphone> smartphones = new ArrayList<>();

        smartphones.add(phone1);
        smartphones.add(phone2);
        smartphones.add(phone3);
        smartphones.add(phone4);
        smartphones.add(phone5);

        System.out.println(smartphones);

        Smartphone phone6 = new Smartphone("12", "Alcatel");

        // ArrayList permitem adicionar itens duplicados
        smartphones.add(phone6);
        System.out.println(smartphones);
        System.out.println("------------");

        /* Neste caso, para evitar que um item seja inserido duplicado, temos o método contais(), que procura um item dentro da lista.
           - Quando utilizamos o contains, o Java percorre item a item da lista, chamando o método equals(), comparando-o com
             cada objeto, retornando true ou false. */
        Smartphone phone7 = new Smartphone("1", "Iphone 12");
        if(! smartphones.contains(phone7)) {
            smartphones.add(phone7);
        }else{
            System.out.println("Aparelho " + phone7.getSerialNumber() + " já existe na lista.");
        }
        System.out.println("------------");

        // Quando há itens repetidos, ao utilizar o método remove(), será removido o primeiro item encontrado. Os demais continuarão na lista.
        smartphones.remove(phone6);
        System.out.println(smartphones);

        // O método indexOf() retorna a posição de um item na lista ou -1, caso o item não esteja na lista.
        if(smartphones.contains(phone6)) {
            System.out.printf("Phone '%s' encontrado na posição %d.\n", phone6.getSerialNumber(), smartphones.indexOf(phone6));
        }
        System.out.println("------------");

        smartphones.remove(phone2);
        System.out.println(smartphones);

        smartphones.add(0, phone2);
        System.out.println(smartphones);
        System.out.println("-------------");

        // Para esvaziar uma lista sem perder a referência da variável atual, utilizamos o método clear()
        smartphones.clear();
        System.out.println(smartphones);

    }
}
