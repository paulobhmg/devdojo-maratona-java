package com.paulo.modulo04_classes_utilitarias.b_datas;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class A116_IntercionalizacaoDeNumerosEMoedas {
    public static void main(String[] args) {
        Locale localBr = new Locale("pt", "BR");
        Locale localJp = Locale.JAPAN;
        Locale localFr = Locale.FRANCE;

        NumberFormat[] nfs = new NumberFormat[4];
        nfs[0] = NumberFormat.getInstance(localJp);
        nfs[1] = NumberFormat.getInstance();
        nfs[2] = NumberFormat.getInstance(localBr);
        nfs[3] = NumberFormat.getInstance(localFr);

        double number = 10_000.2311;

        for(NumberFormat nf : nfs){
            System.out.println(nf.format(number));
        }
        System.out.println("---------------------------");

        // É possível converter um número em String, porém o Parse será feito apenas até o último número válido.
        try {
            System.out.println(nfs[2].parse("10_000.2331")); // Neste caso, apenas o 10 será considerado
            System.out.println(nfs[2].parse("10000,2131"));
            System.out.println(nfs[2].parse("10.000,211"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------");

        // Utilizando agora a NumberFormat para formatação de moeda
        nfs[0] = NumberFormat.getCurrencyInstance(localJp);
        nfs[1] = NumberFormat.getCurrencyInstance();
        nfs[2] = NumberFormat.getCurrencyInstance(localBr);
        nfs[3] = NumberFormat.getCurrencyInstance(localFr);

        for(NumberFormat nf : nfs){
            nf.setMaximumIntegerDigits(5);
            nf.setMaximumFractionDigits(1);
            System.out.println(nf.format(number));
        }

        // Para utilizar o Parse com formatação de moeda é necessário passar como argumento uma String exatamente igual a mascara do valor da moeda.
        try {
            System.out.println(nfs[2].parse("R$ 10.000,2"));
            nfs[2].parse("1.000,00"); // Gera exceção, pois a máscara deve ser respeitada
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* Esse tipo de situação dificilmente vai acontecer em produção, pois as aplicações e bancos de dados armazenam
           os valores numéricos e ao recuperar esses valores, serão apresentados em tela formatados, de acordo com o
           Locale definido. */
    }
}
