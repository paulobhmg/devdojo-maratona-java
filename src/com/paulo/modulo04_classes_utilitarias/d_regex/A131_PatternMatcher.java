package com.paulo.modulo04_classes_utilitarias.d_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Expressões regulares são utilizadas para validar se há uma ou mais ocorrências de um determinado valor, definido como
   Pattern em uma expressão regular. Elas utilizam metacaracteres para definir uma mascara a ser utilizada pelo Pattern,
   retornando um Matcher, que será manipulado para acessar os valores encontrados. */
public class A131_PatternMatcher {
    public static void main(String[] args) {
        Pattern padrao = Pattern.compile("ab");
        Matcher match = padrao.matcher("abacaxi abacateiro eh muito bom e abrangente.");

        System.out.println("Padrão: " + match.pattern());
        System.out.println("Texto: abacaxi abacateiro eh muito bom e abrangente.");
        System.out.println("Total: 012345678901234567890123456789012345678901234");

        System.out.print("Posições encontradas: ");
        while(match.find()){
            System.out.print(match.start() + " ");
        }
        System.out.println("\n------------------------------------------------------\n");

        /* Um Matcher recupera o número do índice do início da palavra buscada pelo Matcher.
           Além disso, deve-se observar que o Match não busca uma única palavra, mas percorre um texto inteiro, retornando
           o index onde inicia cada palavra encontrada, atraves do metodo start(), e o valor encontrado, através do método
           group().

         * É necessário entender que um Matcher, caso encontre o mesmo padrão, juntos, irá considerar apenas o primeiro,
           pois considera o texto inteiro procurado. Sendo assim, no texto abacababaabacaba, caso busque pela palavra "aba",
           serão encontrados apenas 4 ocorrências, embora existam mais.*/

        padrao = Pattern.compile("aba");
        match = padrao.matcher("abacababaabacaba");

        System.out.println("Padrão: " + match.pattern());
        System.out.println("Texto: abacababaabacaba");
        System.out.println("Total: 0123456789012345");

        System.out.print("Posições encontradas: ");
        while(match.find()){
            System.out.print(match.start() + " - " + match.group() + " ");
        }
        System.out.println("\n------------------------------------------------------\n");
    }
}
