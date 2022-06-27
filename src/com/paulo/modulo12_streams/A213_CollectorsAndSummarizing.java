package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* Podemos utilizar o Collectors para retornar uma soma, contagem, valor máximo, valor mínimo sobre uma Stream(), porém
   em muitos desses casos pode ser mais oneroso ou verboso utiliza-lo para isso. */
public class A213_CollectorsAndSummarizing {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        Long count = lightNovels.stream().filter(l -> l.getPrice() < 3).collect(Collectors.counting());
        Double sum = lightNovels.stream().filter(l -> l.getPrice() < 3).collect(Collectors.summingDouble(LightNovel::getPrice));
        Optional<Double> max = lightNovels.stream().map(LightNovel::getPrice).max(Double::compareTo);
        Optional<Double> min = lightNovels.stream().map(LightNovel::getPrice).min(Double::compareTo);
        Double average = lightNovels.stream().filter(l -> l.getPrice() < 3).collect(Collectors.averagingDouble(LightNovel::getPrice));

        System.out.println("count: " + count);
        System.out.println("sum: " + sum);
        System.out.println("max: " + max.orElse(0.0));
        System.out.println("min: " + min.orElse(0.0));
        System.out.println("average: " + average);

        // Todos os itens acima podem ser armazenados dentro de um objeto do tipo DoubleSummaryStatics.
        DoubleSummaryStatistics collect = lightNovels.stream()
                .filter(l -> l.getPrice() < 3).collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        System.out.println(collect.getMax());
        System.out.println(collect.getSum());




    }
}
