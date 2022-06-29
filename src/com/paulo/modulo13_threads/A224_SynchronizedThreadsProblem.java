package com.paulo.modulo13_threads;

import com.paulo.modulo13_threads.domain.Account;

/* Quando trabalhamos com Threads, não há como garantir qual vai ser a ordem de execução de cada thread. Sendo assim,
   uma Thread poderá tomar o lugar da outra, caso seu estado seja alterado para waiting/blocked ou running.

   Podemos observar no exemplo de código abaixo que ao criar duas threads que acessam um mesmo objeto, poderá ocorrer a
   inconsistência dos dados ou operações feitas sobre o objeto, pois a execução das threads podem ser alteradas a qualquer
   momento, por definição do scheduler.

   Nesse exemplo, duas threads fazem saques de 10,00 em uma mesma conta. Então, uma thread entra na operação de saque e logo
   o scheduler troca a thread em execução. A partir daí a outra thred entra no método e pode ou não realizar um saque, ou
   entrar novamente e realizar outro saque. Neste caso, há momentos que as threads entram e não completam a operação do saque,
   gerando a inconsistência dos dados.

   A próxima classe contemplará explicação e solução apra esse problema. */
public class A224_SynchronizedThreadsProblem implements Runnable {
    private final static Account account = new Account(50);

    public static void main(String[] args) {
        A224_SynchronizedThreadsProblem runnable = new A224_SynchronizedThreadsProblem();
        Thread th1 = new Thread(runnable, "th1");
        Thread th2 = new Thread(runnable, "th2");

        th1.start();
        th2.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            withDrawal(10);
            if(account.getBalance() <= 0) {
                System.out.println("Woool");
            }
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    private void withDrawal(double amount) {
        if(account.getBalance() >= amount) {
            System.out.println(getThreadName() + " is going to withdraw.");
            account.withDrawal(amount);
            System.out.println(getThreadName() + " get R$ 10,00. " + account);
        } else {
            System.out.println("There is not balance to " + getThreadName() + " to do.");
        }
    }
}
