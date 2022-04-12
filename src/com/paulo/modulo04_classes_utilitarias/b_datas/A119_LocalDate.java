package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.*;

/* A classe LocalDate foi introduzida no Java8, fornecendo métodos mais simples e usuais, interfaces para acesso e
   manipulação de dadas e traz também o benefício da thread safe (imutabilidade), sendo necessário criar uma nova referência
   ao objeto sempre que houver manipulação na data.

   Trabalha somente com Datas, ou seja, não considera horas. */
public class A119_LocalDate {
    public static void main(String[] args) {
        LocalDate nascimento = LocalDate.of(1992, Month.AUGUST, 17);
        LocalDate dataAtual = LocalDate.now();

        System.out.println(nascimento);
        System.out.println(dataAtual);
        System.out.println("----------------------");

        System.out.println("Total de dias do mês: " + dataAtual.lengthOfMonth());
        System.out.println("Total de dias do ano: " + dataAtual.lengthOfYear());
        System.out.println("É ano bissexto? " + dataAtual.isLeapYear());
        System.out.println("Dia do mês: " + dataAtual.getDayOfMonth());
        System.out.println("Mês por extenso: " + dataAtual.getMonth());
        System.out.println("Ano: " + dataAtual.getYear());
        System.out.println("Número do mês: " + dataAtual.getMonthValue());
        System.out.println("Dia do ano: " + dataAtual.getDayOfYear());
        System.out.println("----------------------");

        /* Recuperando informações através da enumeração ChronoField, que implementa a interface TemporalField,
           fornecendo constantes específicas para acesso aos atributos das classes do Java.Time */
        System.out.println(dataAtual.get(ChronoField.DAY_OF_MONTH));
        System.out.println(dataAtual.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(dataAtual.get(ChronoField.YEAR));
        System.out.println("---- Manipulando LocalDate ----");

        dataAtual = dataAtual.plusDays(10);
        System.out.println("Add 10 dias: " + dataAtual);
        dataAtual = dataAtual.plusDays(20);
        System.out.println("Add 10 dias: " + dataAtual);

        dataAtual = dataAtual.plusMonths(3);
        System.out.println("Add  3 meses: " + dataAtual);
        dataAtual = dataAtual.plusMonths(10);
        System.out.println("Add 10 meses: " + dataAtual);
    }
}
