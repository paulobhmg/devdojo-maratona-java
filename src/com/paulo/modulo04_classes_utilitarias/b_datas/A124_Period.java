package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.LocalDate;
import java.time.Period;

// A classe Period funciona basicamente como a Duration, com a diferença que trabalha apenas com o perído entre datas.
public class A124_Period {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(localDate, localDate.plusYears(3).plusMonths(4).plusDays(8));

        System.out.println(period);
        System.out.printf("%d anos, %d meses, %d dias\n", period.getYears(), period.getMonths(), period.getDays());
        System.out.println("Total de meses: " + period.toTotalMonths());
        System.out.println("-----------------------------");

        /* Ao utilizar o período dessa forma, não é possível utilizar o getMonths, getDays, getYears de forma correta,
           pois o valor retornado não é o cálculo, mas sim o valor de um atributo estático da classe. */
        Period ofDays = Period.ofDays(100);
        Period ofWeeks = Period.ofWeeks(58);
        Period ofMonths = Period.ofMonths(100);
        Period ofYears = Period.ofYears(100).plusMonths(6);

        System.out.println(ofDays);
        System.out.println(ofWeeks);
        System.out.println(ofMonths);
        System.out.println(ofYears);
        System.out.println("----------------------------");

        //OfDays.getMonths() deverá retornar 0. Não tem o valor Mês normalizado nesse período
        System.out.println(ofWeeks.getMonths());
        System.out.println(ofYears.getMonths());

        /* Sendo assim, ao recuperar o GetMonths de um Period, o valor pode ser inconsistente. Para isso, utilizamos
           a classe ChronoUnit, que implementa TemporalUnit, e será vista na próxima aula. */
        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(ofWeeks.getDays())).getMonths());
    }
}
