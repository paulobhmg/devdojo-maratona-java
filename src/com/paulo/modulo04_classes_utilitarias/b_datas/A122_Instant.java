package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Locale;

/* Assim como a classe Date, a Instant trabalha com as datas a partir de 01/01/1970, com a diferença que trabalha
   com nanossegundos. Os nanossegundos a partir dessa é um valor muito grande e foi dividido em dois, sendo recuperados
   através dos métodos getEpochSecond() que retorna o tempo em segundos e getNano(), que retorna o nano dos segundos.

   A classe é utilizada em sistemas que necessitam tratar fusos horários distintos, pois utiliza o zulo-time (UTC) para
   neutralizar a data, ou seja, é necessário converter para o fuso horário atual, dependendo da localidade. */
public class A122_Instant {
    public static void main(String[] args) {
        // É possível trabalhar com datas anteriores à 1970. Apenas o marco inicial do calendário é 1970.
        Instant instantFirst = Instant.ofEpochSecond(-1_000_000_000L);
        System.out.println(instantFirst);

        Instant now = Instant.now();
        System.out.println(now);

        System.out.println(Locale.getDefault());

        /* Para trabalhar com os fusos horários, é necessário saber qual é a diferença entre um fuso horário e o UTC e
           subtrair ou adicionar a diferença em segundos. */
        Instant horaEstadosUnidos = Instant.ofEpochSecond(now.getEpochSecond()).minusSeconds(14400);
        System.out.println(horaEstadosUnidos);

        // Lembrando que essa classe é utilizada em sistemas globais, onde o fuso horário é relevante.
    }
}
