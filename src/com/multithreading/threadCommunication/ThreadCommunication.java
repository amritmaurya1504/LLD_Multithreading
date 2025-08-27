package com.multithreading.threadCommunication;

/*
 * Problem:
 * Without proper communication, one thread may keep "busy waiting" (looping continuously)
 * which wastes CPU and can lead to deadlocks.
 *
 * Solution:
 * Java provides wait(), notify(), notifyAll() to allow threads
 * to efficiently communicate and coordinate work.
 *
 * This program demonstrates the Producer-Consumer problem:
 * - Producer generates data
 * - Consumer uses the data
 * - SharedResource ensures proper synchronization using wait/notify
 */

class SharedResource {
    private int data;          // shared data
    private boolean hasData;   // flag -> true if data is produced but not yet consumed

    // PRODUCER METHOD
    public synchronized void produce(int data) {
        // If data is already present, producer must wait until consumer consumes it
        while (hasData) {
            try {
                // Release lock on SharedResource and wait
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Produce new data
        this.data = data;
        System.out.println("Produced: " + data);

        // Update flag
        hasData = true;

        // Notify waiting consumer that data is ready
        notify();
    }

    // CONSUMER METHOD
    public synchronized int consume() {
        // If no data is available, consumer must wait until producer produces it
        while (!hasData) {
            try {
                // Release lock on SharedResource and wait
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Consume data
        hasData = false;
        System.out.println("Consumed: " + data);

        // Notify producer that space is free to produce again
        notify();

        return data;
    }
}

// PRODUCER THREAD
class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource sharedResource) {
        this.resource = sharedResource;
    }

    @Override
    public void run() {
        // Produces 10 items
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
        }
    }
}

// CONSUMER THREAD
class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // Consumes 10 items
        for (int i = 0; i < 10; i++) {
            sharedResource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // One producer thread
        Thread producerThread = new Thread(new Producer(sharedResource));
        // One consumer thread
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        // Start both threads
        producerThread.start();
        consumerThread.start();
    }
}
