package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;
import com.paulo.modulo12_streams.domain.LightNovelCategoryEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Podemos agrupar vários dados de forma muito fácil com o GroupingBy, que retornará um Map com os valores agrupados
   por chave. */
public class A214_CollectorsGroupingIntroduction {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();
        Map<LightNovelCategoryEnum, List<LightNovel>> mapLightNovels = new HashMap<>();

        // Em um modelo tradicional de dados, caso quisessemos organizar uma lista por categoria, seria assim:
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        List<LightNovel> action = new ArrayList<>();
        List<LightNovel> terror = new ArrayList<>();

        /* Neste exemplo estamos percorrendo uma lista de lightnovels e adicionando os lightnovels em listas auxiliares
           de acordo com a sua categoria. */
        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case DRAMA: drama.add(lightNovel); break;
                case ROMANCE: romance.add(lightNovel); break;
                case ACTION: action.add(lightNovel); break;
                case TERROR: terror.add(lightNovel);
            }
        }

        // Em seguida, adicionamos cada lista à um MAP, tendo como chave a categoria específica.
        mapLightNovels.put(LightNovelCategoryEnum.ACTION, action);
        mapLightNovels.put(LightNovelCategoryEnum.DRAMA, drama);
        mapLightNovels.put(LightNovelCategoryEnum.ROMANCE, romance);
        mapLightNovels.put(LightNovelCategoryEnum.TERROR, terror);

        printMap(mapLightNovels);
        System.out.println("-------------------");

        // Utilizando Streams obtemos o mesmo resultado apenas com a classe Collect
        Map<LightNovelCategoryEnum, List<LightNovel>> mapCollected = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        printMap(mapCollected);
    }

    public static void printMap(Map<LightNovelCategoryEnum, List<LightNovel>> map) {
        for (Map.Entry<LightNovelCategoryEnum, List<LightNovel>> entry : map.entrySet()) {
            System.out.print(entry.getKey().getType() + ": ");
            for (LightNovel lightNovel : entry.getValue()) {
                System.out.printf("%s, ", lightNovel.getTitle());
            }
            System.out.println();
        }
    }
}
