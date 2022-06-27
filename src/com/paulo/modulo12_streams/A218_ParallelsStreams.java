package com.paulo.modulo12_streams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class A218_ParallelsStreams {
    private static long iterates = 10_000_000L;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        sumWithFor(iterates);
        sumWithStream(iterates);
        sumWithParallelStream(iterates);
        System.out.println("------------------------------");

        sumWithParallelLongStream(iterates);
    }

    public static void sumWithFor(long iterates) {
        long result = 0;
        long init = System.currentTimeMillis();
        for(int i = 0; i <= iterates; i ++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.printf("sumWithFor: %d - Time: %d ms.\n", result, (end - init));
    }

    public static void sumWithStream(long iterates) {
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(iterates).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.printf("sumWithStream: %d - Time: %d ms.\n", result, (end - init));
    }

    public static void sumWithParallelStream(long iterates) {
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).parallel().limit(iterates).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.printf("sumWithParallelStream: %d - Time: %d ms.\n", result, (end - init));
    }

    // Neste caso, utilizando o LongStream o java não faz unboxing e autoboxing, aumentando a performance.
    public static void sumWithParallelLongStream(long iterates) {
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, iterates).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.printf("sumWithParallelLongStream: %d - Time: %d ms.\n", result, (end - init));
    }

    /* Ao utilizar o paralelismo com Streams, o java utiliza o Fork framework para dividir as tarefas e juntar o resultado
       após sua conclusão. É importante observar várias coisas, pois o consumo de processamento do computador
       será levado ao extremo.

       1 - Fazer benchmark: Usar bibliotecas externas ou outros meios para verificar o tempo gasto para execução de uma tarefa
       2 - Observar o unboxing e autoboxing, pois esses impactarão diretamente na performance da aplicação
       3 - Obeservar operações que não valem a pena trabalhar paralelamente, como limit, firstFirst | Já o findAny é bom
       4 - Observar o custo total da computação - As vezes dependendo do tamanho do processamento, obtemos ganhos ao paralelizar
       5 - Observar a quantidade de dados - Se a quantidade de dados for pequena, o custo para paralelizar pode ser maior do que o valor efetivo.
       6 - Tipos de coleção: Coleções do tipo ArrayList são boas, LinkedList são ruins, pois devem ser percorridas totalmente.
       7 - Tamanho do Stream: Paralelizar com streams com tamanho definido auxilia na divisao das tarefas, pois sabendo
           exatamente qual é o tamanho do Stream, é possível saber exatamente quantidades de tarefas a serem divididas.
       8 - Observar o tamanho do processamento merge:
         ** A divisão de tarefas se dá da seguinte forma:
         Se a tarefa for pequana e não puder ser dividida, executa sequencialmente a tarefa
         Caso contrário, divide a tarefa recursivamente até que ela não possa mais ser dividida
         Aguarda a execução de todas as tarefas e combina o resultado em um só (Joining).

         ** A etapa de Join é basicamente o processamento do merge. Neste caso é necessário avaliar se é uma boa ideia
            paralelizar as funcionalidades. */
}
