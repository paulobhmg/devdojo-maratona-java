package com.paulo.modulo13_threads;

import com.paulo.modulo13_threads.domain.Members;
import com.paulo.modulo13_threads.service.SendEmailService;

import javax.swing.*;

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
