package com.paulo.modulo13_threads.service;

import com.paulo.modulo13_threads.domain.Members;

public class SendEmailService implements Runnable {
    private final Members members;

    public SendEmailService (Members members) {
        this.members = members;
    }

    @Override
    public void run () {
        System.out.println(Thread.currentThread().getName() + " is starting sending e-mails: ");
        while(members.isOpen() || members.pendingEmails() > 0) {
            String email = members.retrieveEmail();
            if(email == null) continue;
            System.out.println(Thread.currentThread().getName() + " sent email to " + email);
        }
    }
}
