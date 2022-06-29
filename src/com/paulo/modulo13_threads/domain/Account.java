package com.paulo.modulo13_threads.domain;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withDrawal(double amount) {
        this.balance -= amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account balance: " + balance;
    }
}
