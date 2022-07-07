package com.paulo.modulo14_concorrencia;

import java.util.concurrent.*;

/* A interface Callable funciona basicamente como a interface Runnable. A diferença entre as duas é que a Runnable é do
   tipo void e apenas executa uma tarefa, enquanto a Callable é do tipo Generics, retornando um objeto de um tipo
   definido em sua criação, a partir do seu método call().

   Um Callable é executado juntamente com ThreadPools, podendendo ser chamado a partir de um Executor.

   ** Aqui, vale ressaltar que, quando trabalhamos com pool de threads, não é recomendado a utilização dos métodos wait(), notify()
   e notifyAll(), pois isso poderá ocasionar o lock da thread devido ao fato de que não há como saber como a thread está
   sendo executada, pois isso é gerenciado pelo próprio executor.

   ** Outra ressalva importante é que quando trabalhamos com sistemas multithreads, é recomendável utilizar o
   ThreadLocalRandom() caso queira gerar números aleatórios. Isso porquê o Math.random() trabalha de forma sincronizada,
   fazendo o lock para cada thread que acessa o método, enquanto o ThreadLocalRandom() gera um número aleatório para cada
   thread que o executa. */
class RandomMaker implements Callable<String> {
    @Override
    public String call() {
        int num = ThreadLocalRandom.current().nextInt(1, 10);
        for (int i = 1; i <= num; i++) {
            System.out.printf("%s is running the call...\n", Thread.currentThread().getName());
        }
        return String.format("The generated number is %d.", num);
    }
}

public class A238_CallableInterface {
    public static void main(String[] args) {
        RandomMaker maker = new RandomMaker();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        /* Ao utilizar o callable, utilizamos o método submit() do executor. Esse método irá retornar um objeto Future.
           Esse objeto é gerado pois ao executar o submit(), não há como saber quando o Callable será executado, ou seja,
           o valor poderá ser retornado no futuro. Sendo assim, o objeto Future, retornado pelo método submit(), deverá
           armazenar o resultado retornado após a execução da thread.

           Para indicar que thread mais externa deverá esperar a execução da thread atual, é necessário utilizar o método
           get() do objeto Future. Esse método indica para a thread main por exemplo, que ela deverá aguardar o processamento
           do Callable, e somente após finalizado, executar o próximo comando ou finalizar o programa. */

        Future<String> future = executor.submit(maker);

        try {
            System.out.println(future.get());
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing.");
    }
}
