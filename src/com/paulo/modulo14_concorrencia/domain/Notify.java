package com.paulo.modulo14_concorrencia.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Notify {
    private Queue<String> emails = new ArrayBlockingQueue<>(3);
    private boolean open = true;
    private ReentrantLock lock;
    private Condition condition;

    public Notify(ReentrantLock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void add(String email) {
        lock.lock();
        try {
            System.out.printf("%s got the lock to add a new e-mail.\n", getThreadName());
            emails.add(email);
            if(pendingEmails() > 0) {
                System.out.print("Notifying others threads.\n");
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() {
        lock.lock();
        try {
            System.out.printf("%s got the lock to retrieve a e-mail.\n", getThreadName());
            while (pendingEmails() == 0) {
                if(!isOpen()) return null;
                System.out.printf("There is not e-mails to %s retrieve. Waiting...\n", getThreadName());
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return emails.poll();
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

    public void close() {
        lock.lock();
        try{
            System.out.printf("%s is closing the sending e-mail service.\n", getThreadName());
            open = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public boolean isOpen() {
        return open;
    }
}
