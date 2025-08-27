package com.multithreading.threadCommunication;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // wait if full
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // wake up all consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // wait if empty
        }
        int value = buffer.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + value);
        notifyAll(); // wake up producers
        return value;
    }
}

class Producer2 implements Runnable {
    private final SharedBuffer buffer;

    public Producer2(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                buffer.produce(value++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {}
    }
}

class Consumer2 implements Runnable {
    private final SharedBuffer buffer;

    public Consumer2(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}

public class ExtendedProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(new Producer2(buffer), "Producer-1");
        Thread consumer1 = new Thread(new Consumer2(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer2(buffer), "Consumer-2");
        Thread consumer3 = new Thread(new Consumer2(buffer), "Consumer-3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}

