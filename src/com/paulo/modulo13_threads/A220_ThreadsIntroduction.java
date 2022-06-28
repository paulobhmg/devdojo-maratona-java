package com.paulo.modulo13_threads;

/* Utilizamos Threads quando queremos dividir o processamento das tarefas em uma aplicação. Ao utilizar Threads, não temos controle
   sobre a ordem em que elas serão executadas. A JVM é quem escalona qual Thread será executada. Normalmente ocorre a troca
   da execução das Threads.

   Os principais estados das threads são: New, Runnable, Running, Waiting/Blocked, Dead.
   New: É o estado da thread quando é instanciada.
   Runnable: A thread foi startada e está pronta para ser executada.
   Running: A thread está em execução. Nesse estado, ela poderá passar para Waiting/blocked ou voltar para o estado Runnable
   Waiting/Blocked: A thread foi bloqueada ou está dormindo. Desse estado, ela só poderá voltar para Runnable.
   Dead: O ciclo de vida da thread foi finalizado, ou seja, foram executadas todas as tarefas e a thread morreu.

   ** Uma thread não pode alterar o estado de outra. Isso significa que uma thread só entrará em estado sleep, por exemplo,
      se dentro da própria thread for dado o comando para ela dormir. */

// Uma das formas de criar uma Thread, embora não seja a forma correta, é extendendo a classe Thread.
class ThreadPrintExtends extends Thread {
    private final char letter;

    public ThreadPrintExtends(char letter) {
        this.letter = letter;
    }

    // Ao executar uma Thread, o conteúdo que será executado de fato é o que está contido dentro do métod run().
    @Override
    public void run() {
        for (int i = 0; i <= 300; i++) {
            System.out.print(letter);
        }
        System.out.println("\n");
    }
}

// A forma correta de criar um objeto do tipo Thread é implementando a interface Runnable, que fornece o método run()
class ThreadPrintRunnable implements Runnable {
    private final char letter;

    public ThreadPrintRunnable(char letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 300; i++) {
            System.out.print(letter);
        }
        System.out.println("\n");
    }
}

public class A220_ThreadsIntroduction {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println("---------------------------------------");

        /* Thread thread1 = new ThreadPrintExtends('A');
        Thread thread2 = new ThreadPrintExtends('B');
        Thread thread3 = new ThreadPrintExtends('C');
        Thread thread4 = new ThreadPrintExtends('D'); */

        // Neste caso, devemos instanciar a Thread, passando um objeto Runnable em seu construtor.
        Thread thread1 = new Thread(new ThreadPrintRunnable('A'));
        Thread thread2 = new Thread(new ThreadPrintRunnable('B'));
        Thread thread3 = new Thread(new ThreadPrintRunnable('C'));
        Thread thread4 = new Thread(new ThreadPrintRunnable('D'));

        runThreads(thread1, thread2, thread3, thread4);
    }

    /* Ao executar uma thread com o método run(), o Java simplesmente executa o conteúdo do método, não faz com que as
       Threads executem paralelamente. Para que isso ocorra, é necesśario utilizar o método start(); */
    public static void runThreads(Thread... threads) {
        for (Thread thread : threads) {
            // thread.run();
            thread.start();
        }
    }
}
