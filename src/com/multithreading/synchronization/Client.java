package com.multithreading.synchronization;

public class Client {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter, "t1");

    }
}
