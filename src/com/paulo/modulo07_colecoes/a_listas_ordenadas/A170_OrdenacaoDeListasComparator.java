package com.paulo.modulo07_colecoes.a_listas_ordenadas;

/* Quando ordenamos uma coleção, caso estejamos utilizando como parâmetro para ordenação o método compareTo() implementado
   de Comparable, estaremos limitados a apenas um tipo de ordenação e caso seja necessário trocar a implementação no futuro
   poderá haver a quebra da lógica utilizada em outro local do sistema.

   Para solucionar isso, podemos utilizar a interface Comparator, que implementa o método compare(), que irá comparar dois
   objetos do tipo que está sendo ordenado. Dessa forma, podemos utilizar tanto no método List.sort() ou no Collections.sort();

   Neste caso, quando temos um Comparator, o java ignora a implementação feita no método compareTo() do objeto e utiliza
   o método implementado em Comparator */

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortAnimeById implements Comparator<Anime> {
    @Override
    public int compare(Anime anime1, Anime anime2){
        return Long.compare(anime1.getId(), anime2.getId());
    }
}

class SortAnimeByName implements Comparator<Anime> {
    @Override
    public int compare(Anime anime1, Anime anime2) {
        return anime1.getName().compareToIgnoreCase(anime2.getName());
    }
}

class SortAnimeByEpisode implements Comparator<Anime> {
    @Override
    public int compare(Anime anime1, Anime anime2) {
        return Integer.compare(anime1.getEpisodes(), anime2.getEpisodes());
    }
}

public class A170_OrdenacaoDeListasComparator {
    public static void main(String[] args) {
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        List<Anime> animes = new ArrayList<>(List.of(shinge, dragon, bleach, bersek, naruto));

        System.out.println("Lista desordenada: " + animes);
        System.out.println("---------------");

        // Utilizando um Comparator, é possível ordenar uma lista de diversas formas
        animes.sort(new SortAnimeById());
        System.out.println("Lista ordenada por ID: " + animes);
        System.out.println("---------------");

        animes.sort(new SortAnimeByName());
        System.out.println("Lista ordenada por Nome: " + animes);
        System.out.println("---------------");

        Collections.sort(animes, new SortAnimeByEpisode());
        System.out.println("Lista ordenada por episódios: " + animes);
    }
}
