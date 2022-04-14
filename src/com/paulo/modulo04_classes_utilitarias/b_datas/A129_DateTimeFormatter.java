package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// A classe DateTimeFormatter é utilizada para formatar as datas a partir da versão 8 do Java.
public class A129_DateTimeFormatter {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter df2 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter df3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        System.out.println(localDate.format(df));
        System.out.println(localDateTime.format(df2));
        System.out.println(localDateTime.format(df3));
        System.out.println("---------------------");

        // É possível passar um pattern, assim como na classe SimpleDateFormat
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(localDateTime.format(formatter));
        System.out.println("---------------------");

        // Assim como também é possível utilizar o parse, sendo obrigatório utilizar a mesma máscara de um formatador
        System.out.println(LocalDate.parse("17/08/2022 20:10:11", formatter));
        System.out.println(LocalDateTime.parse("17/08/2022 20:10:11", formatter));
        System.out.println("---------------------");

        // Também é possível utilizar um parse já com um formato predefinido
        System.out.println(LocalDate.parse("20220817", DateTimeFormatter.BASIC_ISO_DATE));
    }
}
