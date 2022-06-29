package com.paulo.modulo13_threads;

import com.paulo.modulo13_threads.domain.Members;
import com.paulo.modulo13_threads.service.SendEmailService;

import javax.swing.*;

/* Quando trabalhamos com múltiplas threads e sincronismo, podemos deixar as threads aguardando por quanto tempo quisermos,
   a partir do método wait(), existente em todos os Objetos em Java. Neste caso podemos deixar uma ou várias threads
   em estado wait por um número específico em millissegundos ou até que execute os métodos notify() ou notifyAll().

   Quando esse método é executado, todas as threads que estão aguardando liberação do recurso para aquele objeto, serão liberadas
   para acessá-lo, porém, quem entrar primeiro irá executar. */
public class A228_TestingWaitAndNotifyAll {
    public static void main(String[] args) {
        Members members = new Members();

        Runnable r = new SendEmailService(members);

        Thread t1 = new Thread(r, "thread1");
        Thread t2 = new Thread(r, "thread2");

        t1.start();
        t2.start();

        while(true) {
           String email = JOptionPane.showInputDialog("Input your a new e-mail: ");
           if(email == null || email.isEmpty() || email.isBlank()) {
               members.close();
               break;
           }
           members.add(email);
        }
    }
}
