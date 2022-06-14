package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.*;
import java.time.temporal.ChronoUnit;

/* As classes LocalDate, LocalDateTime e LocalTime possuem um método until(). Para a classe LocalDate, o método método é
   sobrecarregado.
    - Na primeira opção, recebe dois argumentos: O primeiro será a data para calcular a diferença e o segundo
      será um TemporalUnit, representado por alguma unidade da classe ChonoUnit, retornando um long.
    - Na segunda opção, recebe apenas um argumento: A data que será calculada a diferença. Neste caso, retornará um
      Period, que armazena o intervalo e fornece os métodos getYear(), getMonths() e getDays() para acessá-los.

   Para as classes LocalTime e LocalDateTime o método não é sobrecarregado, sendo obrigatório passar os dois argumentos,
   sendo que o primeiro deverá ser do mesmo tipo para compaçao e o segundo, um TemporalUnit.

   *** Já a classe ChronoUnit permite utilizar os atributos estáticos para fazer uma comparação direta entre datas ****/
public class A125_ChronoUnit {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate ani = LocalDate.of(2023, Month.AUGUST, 17);

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime aniTime = ani.atTime(20, 10, 11);

        // Utilizando o until para LocalDate na primeira opçao, passando uma data e um TemporalUnit.
        System.out.println(now.until(ani, ChronoUnit.MONTHS));
        System.out.println(now.until(ani, ChronoUnit.DAYS));
        System.out.println("---------------------------");

        // Utilizando o until para LocalDate na segunda opçao, passando apenas uma data para comparaçao
        Period period = now.until(ani);
        System.out.printf("%d anos, %dm, %dd\n", period.getYears(), period.getMonths(), period.getDays());
        System.out.println("---------------------------------");

        // Utilizando o until para LocalDateTime. Neste caso, e obrigatorio passar os dois argumentos.
        System.out.printf("%dY, %dm, %dw, %dd, %dh:%dm:%ds\n",
            nowTime.until(aniTime, ChronoUnit.YEARS),
            nowTime.until(aniTime, ChronoUnit.MONTHS),
            nowTime.until(aniTime, ChronoUnit.WEEKS),
            nowTime.until(aniTime, ChronoUnit.DAYS),
            nowTime.until(aniTime, ChronoUnit.HOURS),
            nowTime.until(aniTime, ChronoUnit.MINUTES),
            nowTime.until(aniTime, ChronoUnit.SECONDS)
        );
        System.out.println("-------------------------------");

        // Utilizando a própria ChronoUnit para comparação entre intervalos.
        System.out.println(ChronoUnit.YEARS.between(nowTime, aniTime) + " Anos.");
        System.out.println(ChronoUnit.MONTHS.between(nowTime, aniTime) + " Meses.");
        System.out.println(ChronoUnit.WEEKS.between(nowTime, aniTime) + " Semanas.");
        System.out.println(ChronoUnit.DAYS.between(nowTime, aniTime) + " Dias.");
        System.out.println(ChronoUnit.HOURS.between(nowTime, aniTime) + " Horas.");
        System.out.println(ChronoUnit.MINUTES.between(nowTime, aniTime) + " Minutos.");
        System.out.println(ChronoUnit.SECONDS.between(nowTime, aniTime) + " Segundos.");
    }
}
