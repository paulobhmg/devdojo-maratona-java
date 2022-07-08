package com.paulo.modulo14_concorrencia;

import java.util.concurrent.*;

/* Quando trabalhamos com Threads e concorrência da forma tradicional, as threads funcionam de forma síncrona, ou seja,
   uma thread executará uma tarefa até o final. Caso a thread dependa de uma terceira tarefa como buscar informações em
   um servidor por exemplo, a aplicação ficará travada até que a Thread aguarde retorno da requisição feita ao servidor.

   Para esse tipo de caso, devemos trabalhar com códigos assíncronos, ou seja, não será necessário travar a aplicação
   aguardando o retorno de um método assíncrono.

   No exemplo abaixo, um callable simula uma tarefa que busca a cotação do dólar, dorme por 5s e retorna o valor da cotaçao.
   Logo em seguida, o método main executa sua tarefa, independente do retorno ou não do objeto Future. Dessa forma a aplicação
   coninua executando normalmente.

   O método get() do Future pode ficar aguardando por muito tempo pelo resultado de uma requisição, portanto, é possível
   adicionar um timeOut, lançando exeção que deverá ser tratada, caso não consiga recuperar o valor. */
public class A239_Future {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Double> request = executor.submit(() -> {
            System.out.printf("%s is running callable..\n", Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(15);
            return 5.79;
        });

        try {
            System.out.println("Request value with timeout: " + request.get(6, TimeUnit.SECONDS));
            System.out.println("Request value: " + request.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("The value couldn't be retrieved because excepted the timeOut.");
        } finally {
            executor.shutdown();
        }

        System.out.println(Thread.currentThread().getName() + ": " + doSomething());
    }

    public static long doSomething () {
        long num = 0;
        for (int i = 1; i <= 1_000_000_000; i++ ) {
            num += i;
        }
        return num;
    }
}
