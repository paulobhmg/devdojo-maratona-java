package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;
import com.paulo.modulo12_streams.domain.LightNovelCategoryEnum;
import com.paulo.modulo12_streams.domain.LightNovelPromotionEnum;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class A217_AdvancedGroupingBy {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);
        System.out.println("-------------------------------");

        /* Estatística agrupada por categoria. */
        Map<LightNovelCategoryEnum, DoubleSummaryStatistics> collect1 = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.summarizingDouble(LightNovel::getPrice)
                ));
        System.out.println(collect1);
        System.out.println("-------------------------------");

        /* Obtendo a estatística agrupada por categoria e agrupada por tipo de preço */
        Map<LightNovelCategoryEnum, Map<LightNovelPromotionEnum, DoubleSummaryStatistics>> collect2 = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(LightNovel::getPromotion, Collectors.summarizingDouble(LightNovel::getPrice))));
        System.out.println(collect2);
        System.out.println("-----------------------------");

        // Agrupando dados a partir do mapeamento de um Map (funciona como o flatMap
        Map<LightNovelCategoryEnum, Set<LightNovelPromotionEnum>> collect3 = lightNovels
                .stream()
                .collect(
                        Collectors.groupingBy(
                                LightNovel::getCategory,
                                Collectors.mapping(
                                        l -> l.getPrice() < 3 ? LightNovelPromotionEnum.UNDER : LightNovelPromotionEnum.NORMAL,
                                        Collectors.toSet())
                        ));
        System.out.println(collect3);
        System.out.println("------------------------------");

        // É importante observar que esse tipo de agrupamento pode poluir e afetar a legibilidade do código.
    }
}
