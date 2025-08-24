package com.multithreading.synchronization;

public class Counter {
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return this.count;
    }
}
