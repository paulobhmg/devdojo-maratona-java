package com.paulo.modulo12_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* O método reduce() permite que com base em valores contidos em uma Stream(), retornar um único cálculo. */
public class A209_Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 6, 1, 8, 13, 1, 7, 10, 2));

        Integer sumSimpleReduce = numbers.stream().reduce(0, (x, y) -> x + y);
        Integer sumSimpleReduceWithReferenceMethod = numbers.stream().reduce(1, Integer::sum);

        System.out.printf("SumWithReduce: %d, %d\n",sumSimpleReduce, sumSimpleReduceWithReferenceMethod);
        System.out.println("---------------------------------");

        // Nesse exemplo é importante observar que como o inicializador é zero, o resultado sempre será zero, pois 0*n = 0;
        Integer multSimpleReduceZero = numbers.stream().reduce(0, (x, y) -> x * y);
        Integer multSimpleReduce = numbers.stream().reduce(1, (x, y) -> x * y);

        System.out.printf("MultWithReduce: %d, %d\n", multSimpleReduceZero, multSimpleReduce);
        System.out.println("---------------------------------");

        /* Nos exemplos acima, o primeiro parâmetro define um valor inicial para a operação matemática. Caso não seja
           informado o primeiro parâmetro, o resultado será um Optional, pois poderá estar nulo ou vazio e deverá ser tratado. */
        Optional<Integer> optionalNumber = numbers.stream().reduce((x, y) -> x + y);
        Optional<Integer> optionalNumberWithReferenceMethod = numbers.stream().reduce(Integer::sum);

        System.out.print("Optional number if present: ");
        optionalNumber.ifPresent(System.out::print);
        System.out.print(", ");
        optionalNumberWithReferenceMethod.ifPresent(System.out::print);
    }
}
