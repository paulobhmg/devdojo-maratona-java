package com.paulo.modulo04_classes_utilitarias.d_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Utilizamos um range para agrupar expressões que buscam determinado valor. Em um range podemos explicitar um conjunto
   de letras específico ou até mesmo intervalos de letras e números. */
public class A134_RangeEQuantificadores {
    public static void main(String[] args) {
        // Neste exemplo, vamos validar se um determinado texto possui números hexadecimais válidos
        String texto = "0x1aff 0x1b3a ax1vD 0x11x0 0x1bF2 x01b3a 0XFFA1";
        Pattern regex = Pattern.compile("0[xX][a-fA-F0-9]");
        Matcher matcher = regex.matcher(texto);

        while(matcher.find()){
            System.out.printf("%s - %s\n", matcher.start(), matcher.group());
        }
        System.out.println("-----------------");

        /* Em conjunto com um Range é possível utilizar quantificadores para estipular um quantitativo de ocorrências
           permitidos para um Matcher, que são:

           ? - 0 ou uma ocorrência
           * - 0 ou mais ocorrências
           + - 1 ou mais ocorrências
           () - Agrupamento de metacaracters
           | ou
           $ Fim de linha */

        regex = Pattern.compile("0[xX][0-9a-fA-F]+(\\s|$)");
        matcher = regex.matcher(texto);

        while(matcher.find()){
            System.out.printf("%s - %s\n", matcher.start(), matcher.group());
        }
        System.out.println("----------------");

        /* No exemplo acima, para trazer os hexadecimais corretos é necessário continuar a verificação de cada palavra
           até encontrar o caractere espaço ou o final de linha. Portanto, no final é utilizado um agrupador, que define
           que deverá ser utilizado ou um ou outro */
    }
}
