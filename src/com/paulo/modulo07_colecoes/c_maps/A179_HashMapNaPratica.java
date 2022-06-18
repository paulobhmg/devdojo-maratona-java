package com.paulo.modulo07_colecoes.c_maps;

import com.paulo.modulo07_colecoes.domain.Anime;
import com.paulo.modulo07_colecoes.domain.Fritante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A179_HashMapNaPratica {
    public static void main(String[] args) {
        Fritante fritante1 = new Fritante("Paulo");
        Fritante fritante2 = new Fritante("Augusto");
        Fritante fritante3 = new Fritante("Renato");

        Anime shinge = new Anime(1L, "Shingeki no kyogin", 150);
        Anime naruto = new Anime(2L, "Naruto", 1000);
        Anime dragon = new Anime(3L, "Dragon ball", 900);

        Map<Fritante, Anime> watches = new HashMap<>();
        watches.put(fritante1, shinge);
        watches.put(fritante2, naruto);
        watches.put(fritante3, dragon);

        System.out.println(watches);

        for (Map.Entry<Fritante, Anime> fritante : watches.entrySet()) {
            System.out.printf("Fritante: %s - Anime: %s\n", fritante.getKey().getNome(), fritante.getValue().getName());
        }
        System.out.println("---------------------------");

        // No exemplo acima, um fritante frita apenas um anime. Como implementar um Map para que um fritante frite vários animes?
        Map<Fritante, List<Anime>> animesPorFritante = new HashMap<>();
        animesPorFritante.put(fritante1, List.of(dragon, shinge));
        animesPorFritante.put(fritante2, List.of(dragon, shinge, naruto));
        animesPorFritante.put(fritante3, List.of(shinge));

        for(Map.Entry<Fritante, List<Anime>> entry : animesPorFritante.entrySet()) {
            System.out.printf("Fritante: %s\n", entry.getKey().getNome());
            System.out.print("Animes: ");
            for(Anime anime : entry.getValue()) {
                System.out.printf("%s, ", anime.getName());
            }
            System.out.println("\n--------------");
        }
    }
}
