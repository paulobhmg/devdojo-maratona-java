package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;
import com.paulo.modulo12_streams.domain.LightNovelCategoryEnum;
import com.paulo.modulo12_streams.domain.LightNovelPromotionEnum;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A215_CollectorsGroupingBy {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        // Podemos agrupar uma stream a partir do valor retornado pelo predicate de forma dinâmica
        Map<LightNovelPromotionEnum, List<LightNovel>> collect =
                lightNovels.stream()
                        .collect(Collectors.groupingBy(l -> l.getPrice() < 3 ? LightNovelPromotionEnum.UNDER : LightNovelPromotionEnum.NORMAL));
        System.out.println(collect);

        /* O método groupingBy permite fazer um novo agrupamento. Dessa forma, podemos criar vários sub-agrupamentos
           aninhados. É possível fazer isso, porém é melhor deixar essa responsabilidade para o banco de dados, pois é
           uma funcionalidade que não deixa o código muito limpo. */
        Map<LightNovelCategoryEnum, Map<LightNovelPromotionEnum, List<LightNovel>>> collect1 =
                lightNovels
                    .stream()
                    .collect(Collectors.groupingBy(
                            LightNovel::getCategory, Collectors.groupingBy(
                                    l -> l.getPrice() < 3 ? LightNovelPromotionEnum.UNDER : LightNovelPromotionEnum.NORMAL)));
        System.out.println(collect1);
    }
}

