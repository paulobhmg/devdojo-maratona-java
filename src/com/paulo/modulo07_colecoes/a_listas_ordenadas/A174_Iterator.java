package com.paulo.modulo07_colecoes.a_listas_ordenadas;

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A174_Iterator {
    public static void main(String[] args) {
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        Anime dota = new Anime(19L, "Dota2 - Dragon's blood", 21);
        Anime pqn1 = new Anime(7L, "pqn1", 13);
        Anime pqn2 = new Anime(2L, "pqn2", 5);
        Anime pqn3 = new Anime(23L, "pqn3", 9);
        Anime pqn4 = new Anime(8L, "pqn4", 16);
        Anime pqn5 = new Anime(11L, "pqn5", 12);

        List<Anime> animes = new ArrayList<>(List.of(shinge, dragon, bleach, bersek, naruto, dota, pqn1, pqn2, pqn3, pqn4, pqn5));
        animes.sort(new SortAnimeById());

        System.out.println(animes);
        System.out.println("-------------");

        /* Quando utilizamos o iterator() para percorrer uma lista, ele mantém o controle da iteração verificando se tem
           ou não um novo item para ser percorrido. Dessa forma podemos percorrer e remover itens durante a execução do laço
           sem problemas e sem gerar a exceção de ConcurrentOperation. */
        Iterator<Anime> iterator = animes.iterator();
        while(iterator.hasNext()){
            Anime a = iterator.next();
            if(a.getEpisodes() <= 20){
                iterator.remove();
            }
        }

        System.out.println(animes);
        System.out.println("-------------");

        animes.addAll(List.of(pqn1, pqn2, pqn3, pqn4, pqn5));
        System.out.println(animes);
        System.out.println("-------------");

        /* O Java8 trouxe as funcionalidades de programação funcional, facilitando ainda mais o trabalho feito anteriormente,
           utilizando o Iterator(). Basicamente passamos um predicate, ou seja, um teste como parâmetro e por baixo dos panos
           o que o Java faz é executar um Iterator. */
        animes.removeIf(anime -> anime.getEpisodes() <= 20);

        System.out.println(animes);
    }
}
