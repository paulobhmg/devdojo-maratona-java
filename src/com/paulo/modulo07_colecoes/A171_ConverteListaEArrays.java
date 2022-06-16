package com.paulo.modulo07_colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* É possível converter listas em Arrays e vice versa. */
public class A171_ConverteListaEArrays {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3));
        System.out.println("Lista: " + numeros);

        // Transformando uma lista em array
        Integer[] numerosToArray = numeros.toArray(new Integer[0]);
        System.out.println("Array: " + Arrays.toString(numerosToArray));
        System.out.println("---------------------");

        /* Quando criamos uma lista com o método Arrays.asList(), essa lista estará vinculada ao array original e não
           poderá ser alterada. Porém, o array original poderá ser alterado e todas as alterações feitas nele refletirão
           na lista vinculada a ele. */
        List<Integer> numerosToList = Arrays.asList(numerosToArray);
        numerosToArray[0] = 10; // Alterando dado do array irá alterar também na lista, pois estão vinculados.
        System.out.println("Lista vinculada ao array: " + numerosToList);

        // numerosToList.add(10); Este código nao funciona pois a lista é vinculada ao array e nao poderá ser alterada.

        // Para contornar isso, podemos passar a lista vinculada como parâmetro no construtor de uma lista.
        List<Integer> novaLista = new ArrayList<>(Arrays.asList(numerosToArray));
        System.out.println("---------------");

        // Nesse caso, essa nova lista possui os mesmos valores do array, porém não está vinculada.
        novaLista.add(30);
        System.out.println("Nova lista não vinculada: " + novaLista);
        System.out.println("----------------");

        /* Quando utilizamos o Arrays.asList() para criar uma lista, cria-se uma lista imutável, que não poderá ser alterada.
           Neste caso, utiliza-se a criação da lista passando a lista imutável para o construtor, como anteriormente.  */
        List<Integer> listaImutavel = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Lista imutável: " + listaImutavel);
        System.out.println("----------------");

        // listaImutavel.add(10); Erro, pois a lista acima é imutável.

        List<Integer> listaMutavel = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        listaMutavel.add(10);
        System.out.println("Lista mutável: " + listaMutavel);
    }
}
