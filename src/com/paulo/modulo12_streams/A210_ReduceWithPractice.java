package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;

import java.util.List;

public class A210_ReduceWithPractice {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        Double reduce = lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price < 3)
                .reduce(0.0, Double::sum);
        System.out.println(reduce);

        /* A classe LightNovel foi desenvolvida com classe Wrapper, mas caso seu atributo preço fosse de tipo primitivo,
           para cada iteração, o método Double::sum iria efetuar o autoboxing e unboxing para converter entre primitivo e
           Wrapper. Tendo isso em mente, quando utilizamos o map para recuperar valores numéricos, podemos utilizar diretamente
           as classes numéricas, informando ao java que não é para fazer esse processo de conversão e ainda ganhamos alguns métodos */
        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price < 3)
                .sum();
        System.out.println(sum);
    }
}
