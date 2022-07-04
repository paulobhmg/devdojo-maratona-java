package com.paulo.modulo14_concorrencia;

import java.util.concurrent.atomic.AtomicInteger;

/* O pacote de cocorrência cria uma camada de abstração para trabalhar com as threads em Java. Para se trabalhar com ele
   é importante ter conhecimentos aprofundados sobre o pacote de Threads. */
class Counter {
    private int counter;

    /* Neste exemplo, quando utilizamos duas threads para atuar sobre o método increment, incrementando-o até 100.000,
       podemos obter um resultado incorreto ao utilizar o valor da variável no sistema. Isso acontece pois não dá para
       saber a ordem em que as threads estão adicionando dados ao contador e cada thread pode pegar o contador com um valor
       diferente, ocasionando a inconsistência.

       Para resolver isso, o correto é adicionar o synchronized à assinatura do método, pois assim, apenas uma thread poderá
       acessar o recurso por vez. A consequência disso é a perda de performance, exatamente pelo fato de que as threads
       deverão aguardar o processamento da thread atual finalizar para iniciar seu processamento. */
    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class AtomicCounter {
    private AtomicInteger atomic = new AtomicInteger();

    /* Utilizando um objeto atômico, estamos garantindo que as operações serão atômicas e não há a necessidade de sincronizar
       o método. Isso acontece porque a camada de abstração do pacote de concorrência utiliza o conceito de CompareAndSwap,
       fazendo a comparação do valor e trocando caso necessário, garantindo a atomicidade dos dados e evitando o uso do
       sincronismo. */
    public void increment() {
        atomic.incrementAndGet();
    }

    public AtomicInteger getAtomic () {
        return atomic;
    }
}

public class A229_AtomicInteger {
    public static void main(String[] args) {
        Counter counter = new Counter();
        AtomicCounter atomic = new AtomicCounter();

        Runnable r = () -> {
          for (int i = 1; i <= 100000; i++) {
              counter.increment();
          }
        };

        Runnable atR = () -> {
            for (int i = 1; i <= 100000; i++) {
                atomic.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Integer: " + counter.getCounter());

        Thread t3 = new Thread(atR);
        Thread t4 = new Thread(atR);

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Atomic: " + atomic.getAtomic());
    }
}
