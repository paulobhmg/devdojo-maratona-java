package com.paulo.modulo07_colecoes.b_sets;

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.*;
import java.util.stream.Collectors;

/* Set também é uma interface de Collection que funciona de forma similar à List, com algumas diferenças.
   1 - Não permitem elementos duplicados
   2 - Não são indexados, ou seja, não tem o método get() que busca um iten específico na lista. Ou seja, não há como
       saber qual é a posição exata de um elemento dentro da coleção.
   3 - Os elementos são organizados com base em seu hashcode.
   4 - Um Set não possui o método sort() para ordenação, portanto não podem ser ordenadas. */

class SortById implements Comparator<Anime> {
    @Override
    public int compare(Anime anime1, Anime anime2) {
        return Long.compare(anime1.getId(), anime2.getId());
    }
}

public class A175_HashSetAndLinkedHashSet {
    public static void main(String[] args) {
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        Anime naruto2 = new Anime(4L, "Naruto", 1000);
        Set<Anime> animes = new HashSet<>(List.of(shinge, dragon, bleach, bersek, naruto));

        // Ao imprimir, podemos perceber que a lista não segue a ordem de insersão, devido a organização basear-se no hashcode.
        System.out.println(animes);
        System.out.println("-------------");

        // Note que não é possível ordenar um Set, sendo necessário criar um List com base nos valores coletados de um Set.
        List<Anime> animeList = animes.stream().sorted(new SortById()).collect(Collectors.toList());
        System.out.println(animeList);
        System.out.println("-------------");

        /* Não é possível inserir um elemento duplicado. Neste caso, o Java não gera exceção, erro ou aviso.
           Antes de inserir um item o Java verifica através do método equals do objeto se ele já existe na lista. Sendo assim,
           entende-se que inserir dados em um Set é menos performático. */

        animes.add(naruto2);
        System.out.println(animes); // Não tem um novo anime.
        System.out.println("--------------------------------");

        /* Assim como um HashSet, um LinkedHashSet não permite elementos duplicados. A principal diferença entre os dois é
           que o LinkedHashSet mantém a ordem de insersão. Neste caso, ele é pouco performático, pois sempre que um novo item
           é inserido, além da verificação se o item já existe, também é mantida a ordem de insersão. */
        animes = new LinkedHashSet<>(List.of(shinge, dragon, bleach, bersek, naruto));
        System.out.println(animes);
    }
}
