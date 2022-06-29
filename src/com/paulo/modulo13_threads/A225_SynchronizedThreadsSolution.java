package com.paulo.modulo13_threads;

import com.paulo.modulo13_threads.domain.Account;

/* Esta classe possui exatamente o mesmo código da anterior, porém resolvendo a questão do sincronismo.
   Para resolver, devemos informar para o Java que um método ou um objeto não poderá ser acessado de forma síncrona. Isso
   significa que a aperação deverá ser atômica e quando uma thread estiver acessando um método, ele será locked e não será
   acessado a partir de outras threads. Dessa forma, garantimos que outra thread só terá acesso ao método synchronized após
   sua execução, garantindo assim a atomicidade, sem interrupção. */
public class A225_SynchronizedThreadsSolution implements Runnable {
    private static final Account account = new Account(50);

    public static void main(String[] args) {
        A225_SynchronizedThreadsSolution runnable = new A225_SynchronizedThreadsSolution();
        Thread th1 = new Thread(runnable, "th1");
        Thread th2 = new Thread(runnable, "th2");

        th1.start();
        th2.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // withDrawal(10);
            withDrawalWithBlock(10);
            if(account.getBalance() <= 0) {
                System.out.println("Woool");
            }
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    /* Ao adicionar o synchronized à assinatura do método, estamos informando que uma thread executando este método não
       poderá ser interrompida por outra até que a execução do método seja concluída. */
    private synchronized void withDrawal(double amount) {
        if(account.getBalance() >= amount) {
            System.out.println(getThreadName() + " is going to withdraw.");
            account.withDrawal(amount);
            System.out.println(getThreadName() + " get R$ 10,00. " + account);
        } else {
            System.out.println("There is not balance to " + getThreadName() + " to do.");
        }
    }

    /* Podemos também especificar o sincronismo para um objeto específico dentro de um método. Neste caso, devemos
       determinar o synchronized para um objeto específico e delimitar qual é o bloco de código ao qual o objeto deverá ser
       sincronizado. Quando fazemos dessa forma, o método poderá ser chamado por outras threads, mas o OBJETO que está
       locked só poderá ser acessado uma thread por vez.

       Neste caso é importante observar que o objeto deve ser final, pois a referência ao objeto que está lockado não pode
       ser altarada. Sendo assim, a operação de saque só será feita por uma thread, mas várias threads poderão fazer
       essa operação, uma de cada vez, garantindo a atomicidade e a consistência da operação. */
    private void withDrawalWithBlock(double amount) {
        synchronized (account) { // Essa operação deverá ser atômica.
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " is going to withdraw.");
                account.withDrawal(amount);
                System.out.println(getThreadName() + " get R$ 10,00. " + account);
            } else {
                System.out.println("There is not balance to " + getThreadName() + " to do.");
            }
        }
    }
}
