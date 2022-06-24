package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* Streams foram introduzidas a partir da versão 8 do Java e tem como objetivo melhorar ainda mais a funcionalidade
   dos códigos através de estruturas de código declarativas.

   Nesse exemplo de código, vamos fazer duas tarefas:
   1 - Ordenar uma lista de LightNovel por título
   2 - Retornar os 3 primeiros títulos dos ligthNovels com preço < 3.00*/
public class A203_StreamsIntroduction {
    public static void main(String[] args) {
        List<LightNovel> lights = ListGenerator.generateLightNovelsList();
        System.out.println("Original list: " + lights);

        // Ordenando de forma tradicional
        lights.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle())); // Ordenado por titulo
        lights.sort(Comparator.comparing(LightNovel::getPrice)); // Ordenado por preço
        System.out.println("Traditional sorting: " + lights);

        // Pegando os 3 primeiros Light de forma tradicional
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lights) {
            if(lightNovel.getPrice() < 3) {
                titles.add(lightNovel.getTitle());
                if(titles.size() == 3) break;
            }
        }
        System.out.println("3 First LightNovels < 3.00: " + titles);
        System.out.println("-----------------------------");

        /* Streams tem dois tipos de operações: Operações terminais (intermediárias) e operações finais.
           As terminais sempre retornam um Stream, possibilitando assim realizar diversas operações.
           As finais retornam um objeto específico. Sendo assim, não é possível fazer mais operações quando chegamos
           em uma operação final, pois normalmente é o fim do tratamento da Stream. */

        List<String> collect1 = lights.stream()
                .sorted(Comparator.comparingDouble(LightNovel::getPrice))
                .filter(l -> l.getPrice() < 3.00)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}
