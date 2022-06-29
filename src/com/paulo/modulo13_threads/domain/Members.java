package com.paulo.modulo13_threads.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(3);
    private boolean open = true;

    public void add (String email) {
        synchronized (emails) {
            System.out.println(Thread.currentThread().getName() + " add a new e-mail.");
            emails.add(email);
            if(pendingEmails() > 0) {
                System.out.println(Thread.currentThread().getName() + " is notifying that a new e-mail was included.");
                emails.notifyAll();
            }
        }
    }

    public String retrieveEmail () {
        System.out.println(Thread.currentThread().getName() + " is checking if there are e-mails to send.");
        synchronized (emails) {
            while(emails.size() == 0) {
                if(!isOpen()) return null;
                System.out.printf("There are not e-mails to be retrieved to %s, starting on wait mode.\n", Thread.currentThread().getName());
                try {
                    emails.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return emails.poll();
    }

    public int pendingEmails () {
        synchronized (emails) {
            return emails.size();
        }
    }

    public boolean isOpen () {
        return open;
    }

    public void close () {
        System.out.println(Thread.currentThread().getName() + " is closing the e-mail search.");
        open = false;
    }
}
