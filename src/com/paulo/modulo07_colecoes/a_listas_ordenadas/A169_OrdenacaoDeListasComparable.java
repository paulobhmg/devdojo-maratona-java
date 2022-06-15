package com.paulo.modulo07_colecoes.a_listas_ordenadas;

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A169_OrdenacaoDeListasComparable {
    public static void main(String[] args) {
        String anime1 = "Shingeki no kiogyn";
        String anime2 = "Dragon ball";
        String anime3 = "Bleach";
        String anime4 = "Bersek";
        String anime5 = "Naruto";
        List<String> animesStrings = new ArrayList<>(List.of(anime1, anime2, anime3, anime4, anime5));

        // Um ArrayList antes de ser ordenado é classificado de acordo com o número dos seus índexes
        System.out.println("Lista desordenada: " + animesStrings);

        // Para ordenar, podemos utilizar o método sort() da própria lista, ou o método da classe Collections
        Collections.sort(animesStrings);
        System.out.println("Lista ordenada: " + animesStrings);
        System.out.println("---------------------------");

        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        List<Anime> animes = new ArrayList<>(List.of(shinge, dragon, bleach, bersek, naruto));

        System.out.println("Lista desordenada: " + animes);

        /* Para que uma lista seja ordenada a partir do método sort() da classe Collections, é necessário que o objeto
          implemente a interface Comparable. Essa interface fornece o método compareTo(), que é chamado pelo método e
          verifica, com base na lógica criada pelo desenvolvedor, qual será a ordem de ordenação do objeto. */

         Collections.sort(animes); // Testar ordenação por nome ID, nome do anime e número de episódios
         System.out.println("Lista ordenada: " + animes);
    }
}
