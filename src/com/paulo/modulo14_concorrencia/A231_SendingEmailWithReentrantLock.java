package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.Notify;
import com.paulo.modulo14_concorrencia.service.SendEmailService;

import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

/* Neste exemplo, estamos substituindo o envio de e-mail feito utilizando o synchronized pelo uso da classe Lock.
   O codigo do lock esta nas classes de dominio. */
public class A231_SendingEmailWithReentrantLock {
    public static void main(String[] args) {
        Notify notify = new Notify(new ReentrantLock());
        SendEmailService service = new SendEmailService(notify);

        Thread t1 = new Thread(service, "T1");
        Thread t2 = new Thread(service, "T2");

        t1.start();
        t2.start();

        while(notify.isOpen()) {
            String email = JOptionPane.showInputDialog("Input your e-mail:");
            if(email == null || email.isEmpty() || email.isBlank()) {
                notify.close();
                break;
            }
            notify.add(email);
        }
    }
}
