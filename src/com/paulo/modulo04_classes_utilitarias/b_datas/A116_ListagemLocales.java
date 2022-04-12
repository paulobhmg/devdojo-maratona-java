package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.util.Locale;

public class A116_ListagemLocales {
    public static void main(String[] args) {
        String[] isoLanguages = Locale.getISOLanguages();
        String[] isoCountries = Locale.getISOCountries();

        System.out.println("Linguagens disponíveis...");
        for(int i = 0, j = 0; i < isoLanguages.length; i++, j++){
            System.out.printf("%s, ", isoLanguages[i]);
            if(j == 30){
                j = 0;
                System.out.println();
            }
        }
        System.out.println("\n--------------------");

        System.out.println("Países disponíveis... ");
        for (int i = 0, j = 0; i < isoCountries.length; i++, j++){
            System.out.printf("%s, ", isoCountries[i]);
            if(j == 30){
                j = 0;
                System.out.println();
            }
        }
        System.out.println("\n-------------------");
    }
}
