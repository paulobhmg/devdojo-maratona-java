package com.paulo.modulo13_threads;

class ThreadYeldAndJoin implements Runnable {
    private char letter;

    @Override
    public void run () {
        for (int i = 0; i <= 100; i++) {
            System.out.print("A");
        }
        System.out.println();
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}

/* Quando trabalhamos com Threads, temos os métodos yield() e join().
   yield() é um método estático da classe que dá uma dica para o scheduller de que a Thread pode ser pausada, liberando
   processamento para outra thread. Quando isso acontece, uma thread que está no estado running, volta para o estado Runnable
   e pode voltar ao estaru running novamente a qualquer momento, de acrodo com as prioridades do scheduller.

   Já o método join() não é estático, pertence ao objeto e faz com que a Thread principal (a que startou a thread atual)
   só possa passar para a próxima linha do programa e/ou chamar outra thread após a thread atual executar todas as tarefas. */
public class A223_YeldAndJoin {
    public static void main(String[] args) {
        Runnable ka = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.print("kaaaaa");
                Thread.yield();
            }
            System.out.println();
        };

        Runnable me = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.print("mee");
                Thread.yield();
            }
            System.out.println();
        };

        Runnable ha = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.print("haaa");
                Thread.yield();
            }
            System.out.println();
        };

        Thread t1 = new Thread(ka, "tkan");
        Thread t2 = new Thread(me, "tmee");
        Thread t3 = new Thread(ha, "thaa");

        t1.start();
        t2.start();
        try {
            t2.join(); // Após utilizar o Join, o programa executará a thread até o final.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();
    }
}
