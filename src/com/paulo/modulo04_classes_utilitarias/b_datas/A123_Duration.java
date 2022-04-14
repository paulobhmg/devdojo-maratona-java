package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.List;

/* A classe Duration é utilizada para calcular a diferença entre períodos, calculando a diferença em horas, minutos,
   segundos e nanossegundos. Tem como base de cálculo milissegundos e nanossegundos.

   É possível utilizar o Duration com as classes LocalDateTime, LocalTime e Instant, porém não é possível misturá-las.
   Só é possível utilizar o método between para calcular a diferença entre o mesmo tipo. */
public class A123_Duration {
    public static void main(String[] args) {
        Instant instantNow = Instant.now();
        Instant instant = Instant.now().plusMillis(1_000_000_000);

        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.AUGUST, 17, 20, 15);
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        Duration duration = Duration.between(instantNow, instant);
        System.out.println(duration);
        System.out.printf("%d dias, %dh:%dm:%ds\n", duration.toDaysPart(), duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
        System.out.println("------------------------------");

        LocalTime localTime = LocalTime.MIDNIGHT;
        LocalTime localTimeNow = LocalTime.now();

        duration = Duration.between(localDateTimeNow, localDateTime);
        System.out.println(duration);
        System.out.printf("%d dias, %dh:%dm:%ds\n", duration.toDaysPart(),duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
        System.out.println("------------------------------");

        duration = Duration.between(localTime, localTimeNow);
        System.out.println(duration);
        System.out.printf("%dh:%dm:%ds\n", duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
        System.out.println("------------------------------");
    }
}
