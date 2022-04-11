package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.util.Date;

/* A classe Date trabalha com Millissegundos, a partir de 01/01/1970. É uma classe obsoleta, ainda existente no Java
   por questões de retrocompatibilidade com sistemas legados. */
public class A112_Date {
    public static void main(String[] args) {
        Date dataAtual = new Date();
        System.out.println(dataAtual);

        // É possível também instanciar uma data passando um LONG, que será o Millissegundo referente àquela data.
        Date dataAntiga = new Date(1_000_000_000L);
        System.out.println(dataAntiga);

        // Recuperando o tempo de uma data
        long millis = dataAtual.getTime();
        System.out.println(millis);

        // Setando uma data a partir de um long
        dataAtual.setTime(dataAtual.getTime() + 1_000_000_000L);
        System.out.println(dataAtual);

        Date dataFutura = new Date(dataAtual.getTime());
        System.out.println(dataFutura);
    }

}
