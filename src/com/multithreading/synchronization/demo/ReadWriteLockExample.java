package com.multithreading.synchronization.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int count = 0;

    // A ReadWriteLock gives two locks:
    // 1. readLock -> multiple threads can read at the same time
    // 2. writeLock -> only one thread can write at a time
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();   // for reading safely
    private final Lock writeLock = lock.writeLock(); // for writing safely

    // Method to increase count (WRITE OPERATION)
    public void increment(){
        writeLock.lock();  // lock so only one writer can modify at a time
        try{
            count++;  // critical section (updating shared variable)
        }finally {
            writeLock.unlock(); // always unlock in finally block
        }
    }

    // Method to return current count (READ OPERATION)
    public int getCount(){
        readLock.lock();  // multiple readers can take this at once
        try{
            return count; // reading shared variable
        }finally {
            readLock.unlock(); // release after reading
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample counter = new ReadWriteLockExample();

        // Task for reading count value
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    // NOTE: here it directly prints "counter.count"
                    // instead of "counter.getCount()", so it bypasses readLock
                    System.out.println(Thread.currentThread().getName() + " read: " +
                            counter.count);
                }
            }
        };

        // Task for writing (incrementing count)
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    counter.increment(); // safe write using writeLock
                    System.out.println(Thread.currentThread().getName() +
                            " incremented");
                }
            }
        };

        // Creating threads
        Thread writeThread = new Thread(writeTask);
        Thread readThread = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        // Start them
        writeThread.start();
        readThread.start();
        readThread2.start();

        // Wait until all finish
        writeThread.join();
        readThread.join();
        readThread2.join();

        // Final count will be 10 (because only one writeThread increments 10 times)
        System.out.println("Final Count: " + counter.getCount());
    }
}
