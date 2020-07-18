package com.JavaseTest;

public class SyncTest {
    public static void main(String[] args) {
        Account act = new Account(1000);
        Customer customer1 = new Customer(act);
        Customer customer2 = new Customer(act);
        customer1.start();
        customer2.start();
    }
}

class Account{
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public synchronized void deposit(int amt){
        balance += amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"deposit"+balance);
    }
}

class Customer extends Thread{
    private Account act;

    public Customer(Account act){
        this.act = act;
    }

    @Override
    public void run() {
        for(int i=0; i<3; i++){
            act.deposit(1000);
        }
    }
}
