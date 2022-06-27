package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;
import com.paulo.modulo12_streams.domain.LightNovelCategoryEnum;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class A216_ExploringGroupingBy {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        // Podemos adicionar níveis de agrupamentos. Neste exemplo, contamos a quantidade de lightNovels por categoria.
        Map<LightNovelCategoryEnum, Long> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);

        // Já neste outro exemplo, estamos agrupando por categoria e por maior valor, porém, o que obtemos é um Optional
        Map<LightNovelCategoryEnum, Optional<LightNovel>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);

        // Para extrair o valor contido no Optional, podemos utilizar o ColletingAndThen
        Map<LightNovelCategoryEnum, LightNovel> collect2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(LightNovel::getPrice)), Optional::get)));
        System.out.println(collect2);
    }
}
