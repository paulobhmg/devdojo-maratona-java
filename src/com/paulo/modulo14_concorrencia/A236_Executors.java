package com.paulo.modulo14_concorrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {
    private int number;

    public Printer(int number) {
        this.number = number;
    }

    @Override
    public void run () {
        System.out.printf("%s is printing %d\n", Thread.currentThread().getName(), number);
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("%s finished the job.\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/* Executors é uma API dentro do java que abstrai a complexibilidade de trabalhar com Threads e concorrência, separando
   a submissão da execução de uma tarefa. Quando trabalhamos com multiprocessamento, a medida em que criamos threads,
   estamos utilizando os recursos de memória e armazenamento da aplicação, o que pode afetar seu desempenho. Por isso, a API
   Executors cria pools de threads que gerenciam a quantidade de threads utilizadas durante a execução de um programa.

   Sendo assim, não há a necessidade de startar manualmente as Threads. Essa tarefa passa a ser do ExecutorService, que gerencia
   q auantidade de threads que poderão trabalhar de acordo com a quantidade definida. Dessa forma, não importa o número
   de threads que sejam criadas, pois apenas a quantidade definida pelo ExecutorService irá trabalhar e caso sejam criadas
   mais threads, essas ficarão aguardando a disponibilidade da fila para atuarem, de acordo com o gerenciamento da API. */
public class A236_Executors {
    public static void main(String[] args) {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        ExecutorService executorFixed  = Executors.newFixedThreadPool(3); // Cria um pool com número de threads específico
        ExecutorService executorSingle = Executors.newSingleThreadExecutor(); // Cria um pool com uma única thread

        /* Cria um pool de Threads dinâmico, ou seja, vai adicionar threads ao pool a medida que for necessário, reutilizando
           as threads quando elas ficaram disponíveis e criando novas somente se necessário. */
        ExecutorService executorCache  = Executors.newCachedThreadPool();

        executorFixed.execute(new Printer(1));
        executorFixed.execute(new Printer(2));
        executorFixed.execute(new Printer(3));

        /* Neste caso, essas threads só serão executadas a medida que as threads anteriores forem finalizadas, pois existem
           apenas 3 threads no pool de threads. Ou seja, não importa quantos Runnables threads tenha, apenas três threads trabalharão. */
        executorFixed.execute(new Printer(4));
        executorFixed.execute(new Printer(5));

        // Caso a thread seja criada com mais threads do que estão em utilização, elas ficarão em espera, até que sejam ativadas.

        // Diferente do uso comum de Threads, o executor precisa ser finalizado, caso contrário o programa continua rodando.
        executorFixed.shutdown();
        while(!executorFixed.isTerminated()){} // Bloqueia o código de avançar até que o executor finalize todas as threads.

        System.out.printf("%s has done.\n", Thread.currentThread().getName());
    }
}
