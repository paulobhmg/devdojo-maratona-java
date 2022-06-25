package com.paulo.modulo12_streams;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/* Podemos também gerar Streams infinitas. Neste caso, é importante adicionar um limit para que em algum momento a
   iteração sobre a stream seja cessada. */
public class A212_GenerateInfiniteStreams {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2)
                .limit(30)
                .forEach(e -> System.out.print(e + ", "));
        System.out.println("\n----------------------");

        // Para gerar números aletórios por exemplo:
        Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 30))
                .limit(30)
                .forEach(e -> System.out.print(e + ", "));
        System.out.println("\n----------------------");
    }
}
