package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

// Funciona de forma similar à classe LocalDate, com a diferença que aqui o trabalho é apenas com horas.
public class A120_LocalTime {
    public static void main(String[] args) {
        /* A atribuição abaixo é inválida, pois é permitido apenas o intervalo de horas de 23:59:59.999999999
            LocalTime horaErrada = LocalTime.of(24, 59, 60);
        */

        LocalTime horaCorreta = LocalTime.of(23, 59,59);
        LocalTime horaAgora = LocalTime.now();

        System.out.println(horaCorreta);
        System.out.println(horaAgora);
        System.out.println("------------------------");

        System.out.println("Hora: " + horaAgora.getHour());
        System.out.println("Minuto: " + horaAgora.getMinute());
        System.out.println("Segundo: " + horaAgora.getSecond());
        System.out.println("------------------------");

        System.out.println(horaCorreta.get(ChronoField.HOUR_OF_DAY));
        System.out.println(horaCorreta.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.MIN);
        System.out.println("---- Manipulando LocalTime ----");

        // Ao adicionar horas que excedem o número máximo de horas, a hora é resetada e segue o acrescimo das horas.
        horaCorreta = horaCorreta.plusHours(20);
        System.out.println("Add 20 horas: " + horaCorreta);
        horaCorreta = horaCorreta.plusHours(10);
        System.out.println("Add 10 horas: " + horaCorreta);
    }
}
