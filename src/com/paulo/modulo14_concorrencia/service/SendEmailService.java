package com.paulo.modulo14_concorrencia.service;

import com.paulo.modulo14_concorrencia.domain.Notify;

public class SendEmailService implements Runnable {
    private final Notify notify;

    public SendEmailService (Notify notify) {
        this.notify = notify;
    }

    @Override
    public void run () {
        System.out.printf("Thread %s got the lock to send a e-mail.\n", Thread.currentThread().getName());
        while(notify.isOpen() || notify.pendingEmails() > 0) {
            String email = notify.retrieveEmail();
            if(email == null) continue;
            System.out.printf("Thread %s is sending a e-mail: %s\n", Thread.currentThread().getName(), email);
        }
    }
}
