package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/* A classe TemporalAdjusters permite fazer um ajuste no tempo e permite fazer outras verifações. */
public class A126_TemporalAdjusters {
    public static void main(String[] args) {
        // Uma data também pode ser ajustada apartir do withDays, withHours ou withMonth;
        LocalDate now = LocalDate.now().withMonth(8);
        System.out.println(now);
        System.out.println("----------------------");

        // É possível utilizar o método with passando um ChronoUnit
        now = now.with(ChronoField.MONTH_OF_YEAR, 5);
        now = now.with(ChronoField.DAY_OF_MONTH, 4);
        System.out.println(now);
        System.out.println("---------------------");

        // Ajustando uma data com TemporalAdjusters
        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        System.out.println(now);
        System.out.println("---------------------");

        // Um exemplo de uso dessa função é considerar apenas dias úteis em um mês, desconsiderando sábados e domingos.
        now = LocalDate.now();
        System.out.println(now + " - " + getProximoDiaUtil(now));
        System.out.println(now.plusDays(1) + " - " + getProximoDiaUtil(now.plusDays(1)));
        System.out.println(now.plusDays(2) + " - " + getProximoDiaUtil(now.plusDays(2)));
        System.out.println(now.plusDays(3) + " - " + getProximoDiaUtil(now.plusDays(3)));
        System.out.println(now.plusDays(4) + " - " + getProximoDiaUtil(now.plusDays(4)));
        System.out.println(now.plusDays(5) + " - " + getProximoDiaUtil(now.plusDays(5)));
        System.out.println(now.plusDays(6) + " - " + getProximoDiaUtil(now.plusDays(6)));
        System.out.println(now.plusDays(7) + " - " + getProximoDiaUtil(now.plusDays(7)));
        System.out.println(now.plusDays(8) + " - " + getProximoDiaUtil(now.plusDays(8)));
    }

    public static DayOfWeek getProximoDiaUtil(LocalDate data){
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        switch(diaDaSemana){
            case SATURDAY:
            case SUNDAY:
            case FRIDAY:
                diaDaSemana = DayOfWeek.MONDAY;
                break;
            case MONDAY:
                diaDaSemana = DayOfWeek.TUESDAY;
                break;
            case TUESDAY:
                diaDaSemana = DayOfWeek.WEDNESDAY;
                break;
            case WEDNESDAY:
                diaDaSemana = DayOfWeek.THURSDAY;
                break;
            case THURSDAY:
                diaDaSemana = DayOfWeek.FRIDAY;
        }
        return diaDaSemana;
    }
}
