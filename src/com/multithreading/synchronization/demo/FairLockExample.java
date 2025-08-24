package com.multithreading.synchronization.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    // 📝 Create a ReentrantLock with fairness = true
    // "Fair" means: threads acquire the lock in the order they asked for it (FIFO queue).
    // Without fairness (default = false), a thread can "jump the line" if the lock becomes free.
    private final Lock fairLock = new ReentrantLock(true);

    public void accessResource() {
        // 📝 Each thread tries to get the lock
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +
                    " acquired the lock.");

            // 📝 Simulate work (1 second hold of the lock)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 📝 Restore interrupt flag if interrupted during sleep
            Thread.currentThread().interrupt();
        } finally {
            // 📝 Always unlock in finally → ensures lock is released
            System.out.println(Thread.currentThread().getName() +
                    " released the lock.");
            fairLock.unlock();
        }
    }

    public static void main(String[] args) {
        // 📝 Create one FairLockExample instance (shared resource)
        FairLockExample example = new FairLockExample();

        // 📝 Task each thread will run → call accessResource()
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        // 📝 Create 3 threads sharing the same lock
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        // 📝 Start them almost at the same time
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/*
📝 Summary (Baby Style):
- fairLock = new ReentrantLock(true) → Fair lock (FIFO order).
- Thread 1, 2, 3 all try to access the resource.
- With fairness = true → lock is given in order: Thread 1 → Thread 2 → Thread 3.
- Each thread holds the lock for 1 second, then releases it.
- If fairness = false (default) → order is not guaranteed,
  sometimes Thread 3 may "jump" ahead of Thread 2 (unfair scheduling).
*/
