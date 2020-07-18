package com.JavaseTest;

public class SyncTest2 {
    public static void main(String[] args) {
        Account2 act2 = new Account2(1000);
        Customer2 cus2 = new Customer2(act2);
        Thread th1 = new Thread(cus2);
        Thread th2 = new Thread(cus2);
        th1.setName("thread1");
        th2.setName("thread2");
        th1.start();
        th2.start();
    }
}

class Account2{
    private int balance;

    public Account2(int balance){
        this.balance = balance;
    }

    public synchronized void deposit(int amt){
        notify();
        balance += amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  deposit  "+balance);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Customer2 implements Runnable{

    private Account2 act;

    public Customer2(Account2 act){
        this.act = act;
    }

    @Override
    public void run() {
        for(int i=0; i<3; i++){
            act.deposit(1000);
        }
    }
}