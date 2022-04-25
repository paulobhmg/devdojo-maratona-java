package com.paulo.modulo04_classes_utilitarias.d_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A135_CaracterCoringa {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        /* Além dos outros quantificadores, tem também o quantificador coringa ".", que é utilizado para recuperar
           valores entre dois intervalos. Por exemplo, em um texto paulo12345, um regex 1.5 irá retornar tudo que está
           entre 1 e 3, dentro da expressão.

         ** Verificar sites para testar regex online. */
        String texto = "paulo12345";
        Pattern regex = Pattern.compile("(1.3)+"); // Testar isso depois
        Matcher matcher = regex.matcher(texto);

        while(matcher.find()){
            System.out.printf("%s - %s\n", matcher.start(), matcher.group());
        }
        System.out.println("---------------");

        //Validando e-mails válidos.
        String email = entrada.nextLine();
        regex = Pattern.compile("([a-zA-Z]+[a-zA-Z0-9\\._-]*)@[a-zA-Z]+(\\.([a-zA-Z]+)){1,2}$");
        matcher = regex.matcher(email);

        System.out.println(email.matches(regex.toString()));
        while(matcher.find()){
            System.out.printf("%s", matcher.group());
        }

        String cpf = entrada.nextLine();
        regex = Pattern.compile("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}");
        matcher = regex.matcher(cpf);

        System.out.println(cpf.matches(regex.toString()));
        while(matcher.find()){
            System.out.printf("%s", matcher.group());
        }
    }
}
