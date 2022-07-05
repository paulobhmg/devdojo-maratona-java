package com.paulo.modulo14_concorrencia;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* A coleção CopyOnWriteArrayList foi desenvolvida para trabalhar com concorrência. Essa é uma lista imutável, mas funciona
   diferente das listas criadas pelo método Arrays.asList(), que cria uma lista imutável que não adiciona ou remove um item.

   Essa lista permite adicionar e remover itens, porém cria uma nova lista, com o novo item, caso seja adicionado ou
   sem um item, caso seja removido. */
public class A233_CopyOnWriteArrayList {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 5000; i++) {
            list.add(i);
        }

        /* Um iterator armazena a cópia do array original no momento de sua criação, sendo possível acessar os valores
           originais caso uma lista sofra alteração. */
        Runnable printIteratorRunner = () -> {
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2000);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable removingRunner = () -> {
            for (int i = 0; i < 500; i++) {
                System.out.printf("Thread %s is removing %d\n", Thread.currentThread().getName(), i);
            }
        };

        new Thread(printIteratorRunner).start();
        new Thread(printIteratorRunner).start();
        new Thread(removingRunner).start();
    }
}
