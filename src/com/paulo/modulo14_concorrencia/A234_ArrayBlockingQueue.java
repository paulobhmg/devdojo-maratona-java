package com.paulo.modulo14_concorrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* O ArrayBlockingQueue foi desenvolvido para trabalhar com sincronismo e concorrência.
   Esse tipo de coleção não tem espaço dinamicamente alocado, como as listas comuns, sendo obrigatório definir uma capacidade
   em seu construtor. Caso o array esteja cheio e uma thread tente adicionar um novo item, ela ficará bloqueada até que
   seja liberado um novo espaço e assim que libere um novo espaço, a tread é liberada para pegá-lo. Da mesma forma,
   quando ele está vazio, se uma thread tenta pegar um valor, essa ficará bloqueada até que seja adicionado um valor na lista. */
public class A234_ArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> names = new ArrayBlockingQueue<>(1);
        names.put("Paulo");
        System.out.printf("%s added the name '%s' to the list.\n", Thread.currentThread().getName(), names.peek());

        System.out.printf("%s is trying to add another name to the list.\n", Thread.currentThread().getName());
        new Thread(new Runner(names)).start();
        names.put("Tiago");
        System.out.printf("%s added the name '%s' to the list.\n", Thread.currentThread().getName(), names.peek());
    }

   static class Runner implements Runnable {
       private final BlockingQueue<String> names;

       public Runner (BlockingQueue<String> names) {
           this.names = names;
       }

       @Override
       public void run() {
           System.out.printf("%s is going to sleep for 5s.\n", Thread.currentThread().getName());
           try {
               TimeUnit.SECONDS.sleep(5);
               System.out.printf("%s is removing the name '%s' from list.\n", Thread.currentThread().getName(), names.take());
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
   }
}
