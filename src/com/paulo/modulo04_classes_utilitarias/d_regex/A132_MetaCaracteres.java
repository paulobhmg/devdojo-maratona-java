package com.paulo.modulo04_classes_utilitarias.d_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Expressões regulares utilizam metacaracteres para testar um Match. São utilizadas para testar conjuntos de caracteres
   específicos, de acordo com o tipo de metacaractere que está sendo testado.

   Os principais metacaracteres são:
    - \d - Retorna apenas os dígitos em uma expressão
    - \D - Retorna apenas caracteres, exceto dígitos (inclui caracteres especiais)
    - \s - Retorna apenas espaços em branco em uma expressão
    - \S - Retorna tudo em uma expressão, exceto espaços em branco
    - \w - Retorna tudo de A-Z, a-z e underline (exclui caracteres especiais e espaços em branco)
    - \W - Retorna tudo aquilo que não retorna no \w, ou seja, apenas caracteres especiais e espaços em branco. */
public class A132_MetaCaracteres {
    public static void main(String[] args) {
        String regex = "\\d"; //Retornar números
        String texto = "ptanbh1@gmail.com@123_hehe xe xe!";
        Pattern padrao = Pattern.compile(regex);
        Matcher matcher = padrao.matcher(texto);

        System.out.println("Texto: " + texto);
        System.out.println("Lengt: 012345678901234567890123456789012\n");

        System.out.print("Números \\d: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");

        regex = "\\D"; //Retornar caracters (excluíndo números)
        padrao = Pattern.compile(regex);
        matcher = padrao.matcher(texto);
        System.out.print("Caracteres: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");

        regex = "\\s"; //Retornar apenas espaços em branco
        padrao = Pattern.compile(regex);
        matcher = padrao.matcher(texto);
        System.out.print("Espaços em branco: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");

        regex = "\\S"; //Tudo, exceto espaços em branco
        padrao = Pattern.compile(regex);
        matcher = padrao.matcher(texto);
        System.out.print("Texto sem espaços em branco: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");

        regex = "\\w"; // Caracteres, dígitos e underline (exclui caracteres especiais)
        padrao = Pattern.compile(regex);
        matcher = padrao.matcher(texto);
        System.out.print("Texto sem caracteres especiais e espaços em branco: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");

        regex = "\\W"; // Apenas caracteres especiais
        padrao = Pattern.compile(regex);
        matcher = padrao.matcher(texto);
        System.out.print("Apenas caracteres especiais e espaços em branco: ");
        while(matcher.find()){
            System.out.printf("%s - %s, ", matcher.start(), matcher.group());
        }
        System.out.println("\n---------------------------");
    }
}
