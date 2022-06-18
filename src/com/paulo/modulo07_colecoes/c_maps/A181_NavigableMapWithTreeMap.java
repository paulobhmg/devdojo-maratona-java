package com.paulo.modulo07_colecoes.c_maps;

import com.paulo.modulo07_colecoes.domain.Fritante;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

/* Assim como na Interface NavigableSet esta é uma interface ordenada que precisa que os objetos CHAVE implementem a interface
   Comparable ou exige que um Comparator seja passado como argumento em sem construtor. Outro detalhe similar eh o fato de
   que a ordenaçao leva em conta os metodos compareTo() ou compare() ao inves do equals() e hashcode(). */

class SortFritanteByName implements Comparator<Fritante> {
    @Override
    public int compare(Fritante f1, Fritante f2) {
        return f1.getNome().compareToIgnoreCase(f2.getNome());
    }
}
public class A181_NavigableMapWithTreeMap {
    public static void main(String[] args) {
        Fritante fritante1 = new Fritante("Paulo");
        Fritante fritante3 = new Fritante("Tiago");
        Fritante fritante2 = new Fritante("Augusto");
        Fritante fritante4 = new Fritante("Marilene");
        Fritante fritante5 = new Fritante("Nadille");

        /* Neste caso, estamos utilizando a chave como String. Uma String implementa a interface Comparable, logo, é possível
           utilizá-lo como chave, e ela será ordenada por nome, pois a chave é uma String. Dessa forma é possível perceber
           que a ordem de insersão não é respeitada, mas sim a organização definida pela chave. */
        NavigableMap<String, Fritante> fritaAnimesChaveOk = new TreeMap<>();
        fritaAnimesChaveOk.put("frita1", fritante1);
        fritaAnimesChaveOk.put("frita2", fritante2);
        fritaAnimesChaveOk.put("frita3", fritante3);
        fritaAnimesChaveOk.put("frita4", fritante4);
        fritaAnimesChaveOk.put("frita5", fritante5);

        System.out.println(fritaAnimesChaveOk);
        System.out.println("---------------------------------------");

        /* Não é possível utilizar como chave um objeto que não implementa Compable ou se o Map não possuir um Comparator em seu construtor.
           Neste caso, o código abaixo compila, porém em tempo de execução obteremos a exception ClassCastException pois
           é percebido que a chave não é um Comparable e não foi definido um Comparator para a Coleção.

                NavigableMap<Fritante, Fritante> fritaAnimesChaveFail = new TreeMap<>();
                fritaAnimesChaveFail.put(fritante1, fritante1); */

        // O código abaixo é permitido pois adicionamos um Comparator na declaração do TreeMap.
        NavigableMap<Fritante, String> fritaAnimesChaveObjetoOk = new TreeMap<>(new SortFritanteByName());
        fritaAnimesChaveObjetoOk.put(fritante1, "Paulo");
        fritaAnimesChaveObjetoOk.put(fritante2, "Augusto");
        fritaAnimesChaveObjetoOk.put(fritante3, "Tiago");
        fritaAnimesChaveObjetoOk.put(fritante4, "Marilene");
        fritaAnimesChaveObjetoOk.put(fritante5, "Nadille");
        System.out.println(fritaAnimesChaveObjetoOk);
        System.out.println(fritaAnimesChaveObjetoOk.descendingMap());
        System.out.println("---------------------------------------");

        /* Conseguimos também recuperar um novo Map com todos os itens abaixo ou acima de um item específico.
           Observar a diferença entre o headMap() e o tailMap().
             No headMap(), por default o segundo parâmetro é falso, ou seja, o item não é incluso
             No tailMap(), por default, é true, ou seja, o item já é incluso. */
        System.out.println("Abaixo: " + fritaAnimesChaveOk.headMap("frita3")); // Item não incluso
        System.out.println("Abaixo ou igual: " + fritaAnimesChaveOk.headMap("frita3", true)); // Item incluso
        System.out.println("---------------------------------------");

        System.out.println("Acima: " + fritaAnimesChaveOk.tailMap("frita3", false)); // Item não incluso
        System.out.println("Acima ou igual: " + fritaAnimesChaveOk.tailMap("frita3")); // Item incluso
        System.out.println("---------------------------------------");

        /* O método acima é linkado ao Mapa original, igual o Arrays.asList() vincula a lista ao array original.
           Sendo assim, é importante observar que as alterações feitas em headMap() e tailMap() refletirão no original. */

        System.out.println("Item removido headMap(): " + fritaAnimesChaveOk.headMap("frita3").remove("frita1"));
        System.out.println("Map original: " + fritaAnimesChaveOk);
    }
}
