package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/* A classe Locale é utilizada para a intercionalização de datas, números, moedas, possibilitando defini-los como
   pertencentes ao Local definido pelo usuário ou de acordo com a configuração da JVM. */
public class A115_IntercionalizacaoDeDatas {
    public static void main(String[] args) {
        Locale localBrasil = new Locale("pt", "BR");
        Locale localUsa = new Locale("us", "US");
        Locale localItaly = new Locale("it", "IT");

        Calendar cb = Calendar.getInstance();
        Calendar cu = Calendar.getInstance();
        Calendar it = Calendar.getInstance();

        // A classe Locale é utilizada para formatar a data. Nesse caso, é passado como argumento para a classe DateFormat.
        DateFormat dfb = DateFormat.getDateInstance(DateFormat.FULL, localBrasil);
        DateFormat dfu = DateFormat.getDateInstance(DateFormat.FULL, localUsa);
        DateFormat dfi = DateFormat.getDateInstance(DateFormat.FULL, localItaly);

        System.out.println(dfb.format(cb.getTime()));
        System.out.println(dfu.format(cu.getTime()));
        System.out.println(dfi.format(it.getTime()));
        System.out.println("--------------------------");

        Locale[] locales = Locale.getAvailableLocales();
//        for(Locale local : locales){
//            System.out.println(local.getDisplayCountry(localBrasil));
//        }

        for (String isoLanguage : Locale.getISOLanguages()) {
            System.out.println(isoLanguage);
        }

        for (String isoCountry : Locale.getISOCountries()) {
            System.out.println(isoCountry);
        }
        System.out.println("--------------------");

        // Acessando alguns atributos da classe Locale.
        System.out.println(Locale.getDefault());
        System.out.println(localBrasil.getDisplayName(localBrasil));
        System.out.println(localBrasil.getDisplayCountry());
        System.out.println(localBrasil.getDisplayLanguage());
        System.out.println(localBrasil.getLanguage());
        System.out.println(localBrasil.getCountry());
    }
}
