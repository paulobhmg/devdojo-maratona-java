package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/* A classe LocalDateTime funciona de forma similar às duas anteriores, porém trabalha com a data e hora.
   Aqui há ainda a possibilidade de instanciar uma LocalDateTime a partir de um LocalDate ou LocalTime já instanciado. */
public class A121_LocalDateTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println("-------------------");

        // Instanciando LocalDateTime normalmente
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, Month.AUGUST, 17, 20, 10, 53);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println("-------------------");

        // Instanciando LocalDateTime com base em LocalDate e LocalTime previamente criados.
        LocalDateTime timeFromDate = localDate.atTime(localTime);
        LocalDateTime dateFromTime = localTime.atDate(localDate);
        System.out.println(timeFromDate);
        System.out.println(dateFromTime);
        System.out.println("---- Manipulando LocalDateTime ----");

        timeFromDate = timeFromDate.plusHours(50);
        System.out.println("Add  50 horas: " + timeFromDate);
        timeFromDate = timeFromDate.plusHours(240);
        System.out.println("Add 240 horas: " + timeFromDate);
    }
}
