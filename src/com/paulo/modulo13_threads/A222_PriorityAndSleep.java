package com.paulo.modulo13_threads;

class RunnableThread implements Runnable {
    private final char letter;

    @Override
    public void run() {
        for (int i = 0; i <= 200; i++) {
            System.out.print(letter);

            try {
                Thread.sleep(1400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public RunnableThread(char letter) {
        this.letter = letter;
    }
}

/* A classe Thread possui o método estático sleep(). Esse método faz com que a Thread pare de executar por um tempo passado
   em millisegundos como argumento. Quando temos Threads rodando em paralelo, a ordem de execução das Threads é definida pelo
   escalonador da JVM. Sendo assim, nem mesmo que todas as threads tenham o mesmo código, a ordem em que vai acontecer a
   pausa é desconhecida.

   Podemos também sugerir uma prioridade para a execução das Threads, sendo: 1 - prioridade mínima , 10 - prioridade máxima.

   Quando uma thread é setada para prioridade máxima, não significa que ela será de fato a Thread priorizada, mas sim uma
   sugestão informando para a JVM que gostaríamos que ela fosse priorizada. A decisão de priorizar ou não, não é peculiar
   ao desenvolvedor. */

public class A222_PriorityAndSleep {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableThread('A'), "Thead1");
        Thread t2 = new Thread(new RunnableThread('B'), "Thead2");
        Thread t3 = new Thread(new RunnableThread('C'), "Thead3");
        Thread t4 = new Thread(new RunnableThread('D'), "Thead4");

        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
