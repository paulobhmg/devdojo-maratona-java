package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/* A Interface TemporalAdjuster pode ser implementada em classes que manipulam objetos do tipo Temporal.
   Nesse exemplo, a classe Adjuster atuará como um TemporalAdjuster, que possui o adjustInto sobrescrito.
   Esse método vai receber um objeto do tipo Temporal e caso o dia da semana seja Sexta, sábado ou domingo, retornará
   uma nova data com dias acrescentados até o próximo dia útil. */

public class A127_TemporalAdjuster  {
    public static void main(String[] args) {
        LocalDate dateNow = LocalDate.now();
        LocalDate proximoDiaUtil = dateNow.with(Adjuster.getInstance());

        System.out.println("Próximo dia útil: " + proximoDiaUtil);
        System.out.println("-------------------------");
        proximoDiaUtil = dateNow.plusDays(1).with(Adjuster.getInstance());
        System.out.println("Próximo dia útil: " + proximoDiaUtil);
        System.out.println("-------------------------");

        System.out.println(LocalDate.now().plusDays(2).with(Adjuster.getInstance()));
        System.out.println(LocalDate.now().plusDays(3).with(Adjuster.getInstance()));
        System.out.println(LocalDate.now().plusDays(4).with(Adjuster.getInstance()));
    }
}
