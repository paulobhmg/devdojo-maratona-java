package com.paulo.modulo14_concorrencia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* A interface Lock trabalha de forma similar à synchronized, fornecendo mais vantagens como bloquear o lock, tentar pegar
   o lock por alguns segundos antes de dormir, tentar priorizar o lock para a thread que está a mais tempo na fila, através
   do parâmetro do construtor, permite ver o número de threads aguardando pela liberação do lock e outras vantagens.

   Como desvantagem, o código fica um pouco mais poluído, sendo necessário abstrair a funcionalidade de um lock caso seja
   implementado. Abstrair essa complexidade em um método ou uma classe utilitária por exemplo, não fará com que o código
   fique mais limpo, apenas estará jogando a sujeira do código para outro local. */
class Worker implements Runnable {
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            if(lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s pegou o lock.\n", name);
            }
            Thread.sleep(1000);
            System.out.printf("Thread %s irá dormir por 1s. Threads na fila: %d\n", name, lock.getQueueLength());
            System.out.printf("Thread %s finalizou o processamento.\n", name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        return name;
    }

    public Lock getLock() {
        return lock;
    }
}

public class A230_LockAndReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}
