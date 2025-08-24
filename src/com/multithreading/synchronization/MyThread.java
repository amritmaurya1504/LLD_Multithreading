package com.multithreading.synchronization;

public class MyThread extends Thread{
    private Counter counter;

    public MyThread(Counter counter, String name){
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000 ; i++) {
            counter.increment();
        }
    }
}
