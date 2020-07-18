package com.JavaseTest;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Clerk cl = new Clerk();
        Customer3 customer3 = new Customer3(cl);
        Producer producer1 = new Producer(cl);
        Producer producer2 = new Producer(cl);
        customer3.setName("Thread-Customer1");
        producer1.setName("Thread-Producer1");
        producer2.setName("Thread-Producer2");
        customer3.start();
        producer1.start();
        producer2.start();
    }
}

class Clerk{

    private int productCount = 0;

    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+" is producing NO."+productCount);
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productCount>0){
            productCount--;
            System.out.println(Thread.currentThread().getName()+" is consuming NO."+productCount);
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer3 extends Thread{
    private Clerk clerk;
    public Customer3(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+" start consuming...");
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + " start producing...");
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}