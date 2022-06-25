package com.paulo.modulo12_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* É possível obter Streams sem a necessidade de utilizar uma lista específica para isso. */
public class A211_GenerateStreams {
    public static void main(String[] args) {
        // Range exclui o último valor do intervalo, RangeClosed inclui.
        IntStream range = IntStream.range(10, 50);
        IntStream rangeClosed = IntStream.rangeClosed(10, 50);

        range.filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + ", "));
        System.out.println();
        rangeClosed.filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + ", "));
        System.out.println("\n------------------------------");

        // Streams numéricos nos fornecem alguns métodos específicos para cálculo, excluindo a necessidade de reduce()
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum with IntStream: " + sum);

        // No caso de utilizar a operação de média, o retorno é um Optional, pois pode não haver média calculada
        OptionalDouble average = IntStream.rangeClosed(1, 10).average();
        average.ifPresent(m -> System.out.println("Average with IntStream: " + m));
        System.out.println("--------------------------------");

        // Quando criamos um Stream de arrays de forma direta, o retorno também é um IntStream, permitindo executar os cálculos
        int[] numbers = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(numbers);

        System.out.println("Sum of Array's IntStream: " + stream.sum());
        System.out.println("--------------------------------");

        // Também podemos utilizar Streams para manipulação de arquivos.
        try (Stream<String> file = Files.lines(Paths.get("src/com/paulo/modulo12_streams/files/file.txt"))) {
            file.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------");

        try(Stream<String> file = Files.lines(Paths.get("src/com/paulo/modulo12_streams/files/file.txt"))) {
            file.filter(s -> s.contains("Java")).forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
