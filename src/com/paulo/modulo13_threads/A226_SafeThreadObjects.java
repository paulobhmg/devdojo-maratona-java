package com.paulo.modulo13_threads;

/* Dizer que uma classe é ThreadSafe significa que os métodos para manipular a classe são atômicos, ou seja, a assinatura
   dos métodos da classe é synchronized. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MakeThreadSafeList {
    private List<String> developers = Collections.synchronizedList(new ArrayList<>(List.of("Paulo")));

    /* No exemplo abaixo estamos criando uma lista síncrona. Neste caso, o método remove() da lista é atômico, porém estamos
       abstraindo esse método para dentro de um método de nível acima. Como o método externo não é síncrono, não há o sincronismo,
       pois a thread esta atuando diretamente sobre ele. */
    public void removeFirst () {
        if (developers.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Dropping developer " + developers.remove(0));
        }
    }

    // Já aqui, como sincronizamos o método, ele executará os métodos da lista também de forma síncrona.
    public synchronized void removeFirstSynchronized () {
        if(developers.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Dropping developer " + developers.remove(0));
        }
    }
}

public class A226_SafeThreadObjects {
    public static void main(String[] args) {
        MakeThreadSafeList genList = new MakeThreadSafeList();
        Runnable r = genList::removeFirst;
        Runnable r2 = genList::removeFirstSynchronized;

      // Thread t1 = new Thread(r);
      // Thread t2 = new Thread(r);

        Thread t1 = new Thread(r2);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
