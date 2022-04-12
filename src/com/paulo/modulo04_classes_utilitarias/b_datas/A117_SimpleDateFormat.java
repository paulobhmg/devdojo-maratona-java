package com.paulo.modulo04_classes_utilitarias.b_datas;

import com.sun.source.tree.NewArrayTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* A classe SimpleDateFormat é uma extensão de DateFormat e permite uma formatação de datas mais dinâmica, com base em
   caracteres padrões definidos pela classe que determinam o formato da máscara. */
public class A117_SimpleDateFormat {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        System.out.println(sdf.format(c.getTime()));

        sdf = new SimpleDateFormat("'Belo Horizonte', EEEE, dd 'de' MMMM 'de' yyyy.");
        System.out.println(sdf.format(c.getTime()));

        //Aqui também temos o parse, que deve seguir a risca a másca
        try {
            System.out.println(sdf.parse("Belo Horizonte, Tuesday, 12 de April de 2022."));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
