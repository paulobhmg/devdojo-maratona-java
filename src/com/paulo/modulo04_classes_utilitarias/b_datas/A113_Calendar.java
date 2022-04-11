package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;

/* A classe Calendar foi a segunda classe criada para trabalhar com Java, com o objetivo de melhorar o trabalho com datas
   e fornecer também a intercionalização de datas. Embora seus métodos não sejam obsoletas, como a classe Date, também
   não é utilizada em novos projetos, mas bastante encontrada em sistemas legados.

   Calendar é uma classe Abstrata e não pode ser instanciada diretamente, sendo necessário utilizar os métodos da própria
   classe, que retornaram um Calendário Gregoriano. */
public class A113_Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println("--------------------");

        // É possível instanciar uma classe do tipo Date, através do método getTime() da classe Calendar
        Date dataAtual = c.getTime();
        System.out.println(dataAtual);

        dataAtual = new Date(c.getTimeInMillis());
        System.out.println(dataAtual);
        System.out.println("--------------------");

        // Uma instância de Calendar pode ser acessados e manipulados através dos métodos GET e SET.
        c.set(2022, Calendar.AUGUST, 17);
        System.out.printf("%d/%d/%d\n", c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
        System.out.println("--------------------");

        System.out.println(c.getCalendarType());
        System.out.println(c.getFirstDayOfWeek());
        System.out.println(c.getWeeksInWeekYear());
        System.out.println(c.getWeekYear());
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println("--------------------");

        /* Podemos alterar uma instância de Calendar a partir dos métodos add e roll. A diferença entre os dois é que
           o método ADD vira segundos para minuto, minutos para hora, hora para dias e assim por diante, enquanto o método
           roll adiciona um período sem alterar os dias.

           Para exemplificar, vou trabalhar com data e hora fixos. */

        c.set(2022, Calendar.AUGUST, 17, 15, 53);
        System.out.printf("%d/%d/%d %d:%d\n",
            c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));

        // Ao adicionar 10h com o método ADD, a data também será alterada, pois passará de 24h.
        c.add(Calendar.HOUR_OF_DAY, 10);
        System.out.printf("%d/%d/%d %d:%d\n",
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));

        // Se eu adicionar minutos a essa data, as horas também serão alteradas.
        c.add(Calendar.MINUTE, 2000);
        System.out.printf("%d/%d/%d %d:%d\n",
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
        System.out.println("-----------------------");

        // Ao utilizar o método ROLL, independente da quantidade de dias, horas, minutos ou segundos adicionados, o que ocorrerá é o RESET do campo referenciado.
        c.roll(Calendar.DAY_OF_MONTH, 20); // Mantem o mesmo mes.
        System.out.printf("%d/%d/%d %d:%d\n",
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));

        c.roll(Calendar.HOUR_OF_DAY, 17); // Mantem o mesmo dia.
        System.out.printf("%d/%d/%d %d:%d\n",
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));

        c.roll(Calendar.MINUTE, 2000); // Mantem a mesma hora.
        System.out.printf("%d/%d/%d %d:%d\n",
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
        System.out.println("---------------------");
    }
}
