package com.paulo.modulo07_colecoes.a_listas_ordenadas;

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.LinkedList;
import java.util.List;

/* Um LinkedList, assim como ArrayList, é uma implementação de List, tendo como principal diferença a forma como os índexes
   são relacionados. Em um LinkedList, um índex conhece o próximo e o anterior. Sendo assim, há diferença de performance
   dependendo da operação que pretende-se utilizar (verificar depois a performance do BIG-O).
   Um linkedList é mais performático para remover elementos. Sendo assim, caso uma aplicação demande várias remoções
   de elementos em uma lista, esse tipo de lista é uma boa implementação. */

public class A175_LinkedList {
    public static void main(String[] args) {
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        List<Anime> animes = new LinkedList<>(List.of(shinge, dragon, bleach, bersek, naruto));

        System.out.println(animes);
        System.out.println("-----------------");

        animes.remove(naruto);
        System.out.println(animes);

        animes.sort(new SortAnimeById());
        System.out.println(animes);
    }
}
