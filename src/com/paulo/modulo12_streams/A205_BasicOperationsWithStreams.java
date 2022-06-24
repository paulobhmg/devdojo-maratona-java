package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Stream;

public class A205_BasicOperationsWithStreams {
    private final static List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovels.stream();

        // Como vimos, podemos utilizar uma stream para efetuar várias operações
        long count = stream.filter(l -> l.getPrice() < 3)
                .count();
        System.out.println("Total of lightNoves with price < 3: " + count);

        /* Quando efetuamos operações com um Stream, basicamente abrimos um fluxo de dados e ao terminar as operações
           fechamos o fluxo. Quando o fluxo é fechado, não é mais possível abrir o mesmo Stream já utilizado anteriormente,
           sendo necessário gerar um novo Stream direto da fonte. Dessa forma, a operação executada abaixo não apresenta
           erro de compilação, mas em tempo de execução irá gerar um IllegalStateException, pois houve alteração no
           estado da Stream. */
        try {
            long countDistinct = stream
                    .filter(l -> l.getPrice() < 3)
                    .distinct()
                    .count();
            System.out.println(countDistinct);
        } catch (RuntimeException e) {
            System.out.println("Cannot open the same Stream again.");
        }

        // Dessa forma, o correto é gerar uma nova Stream e executar as operações acima.
        long countDistinct = lightNovels.stream()
                .distinct()
                .filter(l -> l.getPrice() < 3)
                .count();
        System.out.println("Total of distinct lightNovels with price < 3: " + countDistinct);
    }
}
