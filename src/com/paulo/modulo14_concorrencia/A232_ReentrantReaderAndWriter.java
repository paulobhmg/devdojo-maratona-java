package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.MapReadWriter;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/* A classe ReentrantReaderWriteLock funciona de forma similar à ReentrantLock, com a diferença que trabalha especificamente
   com os locks de leitura e escrita.

   Para leitura, várias threads podem obter o mesmo lock, enquanto para escrita, apenas uma thread poderá obtê-lo.
   ** Ao executar uma leitura, é importante verificar se o lock está travado para escrita, pois se o objeto estiver
   lockado para escrita, não é recomendável fazer a leitura, pois os dados podem estar inconsistentes. */
public class A232_ReentrantReaderAndWriter {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        MapReadWriter map = new MapReadWriter(lock);

        Runnable writer = () -> {
            for (int i = 1; i <= 20; i++) {
                map.put(i, i);
            }
        };

        Runnable reader = map::reader;

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);

        t1.start();
        t2.start();
        t3.start();
    }
}
