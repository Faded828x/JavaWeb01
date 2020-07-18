package com.JavaseTest;

public class SynchronizedTest {
    public static void main(String[] args) {
        MyThread2 th = new MyThread2();
        Thread t = new Thread(th);
        Thread t2 = new Thread(th);
        t.setName("ticket1");
        t2.setName("ticket2");
        t.start();
        t2.start();

    }
}

class MyThread2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            synchronized (MyThread2.class){
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"-"+ticket);
                    ticket--;
                } else
                    break;
            }
        }
    }
}
