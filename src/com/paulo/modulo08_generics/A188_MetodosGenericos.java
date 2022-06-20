package com.paulo.modulo08_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Quando queremos utilizar o Generics em uma classe que não é genérica, a sintaxe utilizada na declaração de um método
   é diferente. */
public class A188_MetodosGenericos {
    public static void main(String[] args) {
        String[] nomes = {"Paulo", "Tiago", "Renato", "Augusto", "Marilene"};
        imprimeArrayDeObjetoT(nomes);

        List<String> nomesList = geraListaDeObjetos(nomes);
        System.out.println(nomesList);
    }

    // Neste caso, o <T> deve vir após o modificador e antes do tipo de retorno (seja void ou não)
    public static <T> void imprimeArrayDeObjetoT(T[] objeto){
        for (T t : objeto) {
            System.out.printf(t + ", ");
        }
        System.out.println();
    }

    @SafeVarargs
    public static <T> List<T> geraListaDeObjetos(T... t) {
        return new ArrayList<>(Arrays.asList(t));
    }
}
