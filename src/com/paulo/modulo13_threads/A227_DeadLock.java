package com.paulo.modulo13_threads;

/* Já sabemos que quando trabalhamos com sincronismo, quando uma thread acessa um objeto, esse objeto estará locked, ou seja,
   caso outra thread queira acessar aquele objeto, ela deverá aguardar até que a thread atual termine o processamento e só
   depois acessará o recurso. A nova thread fará um locked no objeto e só liberará após concluir seu processamento.

   Sendo assim, uma aplicação com 10 threads que acessam o mesmo recurso, as threads entrarão em uma fila, aguardando o
   recurso ser liberado para atuar. Nesse sentido, imaginando que temos duas threads e um recurso, podemos obter a seguinte situação:

   A thread1 pegou o lock do objeto1
   A thread2 pegou o lock do objeto2
   Em determinado momento, a thread1 precisa acessar o objeto que está locked pela thread2. Neste caso, a thread1 fica aguardando
   a thread2 liberar o lock para acessar o recurso.
   Porém, a thread2 também precisa acessar o objeto que está locked pela thread1 e fica aguardando a liberação do lock para
   atuar sobre o objeto.

   Quando isso ocorre, as duas threads vão ficar aguardando por algo que nunca vai acontecer, pois thread1 está lockando o
   objeto que a thread2 está esperando e por sua vez, thread2 está lockando o objeto que thread1 está esperando. Isso é
   o chamado DeadLock, pois as threads ficarão esperando infinitamente e nunca seguirão em frente com sua execução.

   Quando acontece o deadlock, a aplicação deve ser reiniciada, pois não há o que fazer, já que ambas as threads estarão
   aguardando liberação do recurso para seguir em frente. */
public class A227_DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable r1 = () -> {
            synchronized (lock1) {
                System.out.println("Thread1 locking lock1.");
                System.out.println("Thread1 waiting for other thread unlock lock2.");
                synchronized (lock2) {
                    System.out.println("Thread1 locking lock2.");
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (lock2) {
                System.out.println("Thread2 locking lock2.");
                System.out.println("Thread2 waiting for other thread unlock lock1");
                synchronized (lock1) {
                    System.out.println("Thread2 locking lock1.");
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
