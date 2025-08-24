package com.multithreading.synchronization.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    // 📝 ReentrantLock means:
    // If a thread already has the lock, it can take it again without getting blocked.
    // (Normal Lock would deadlock here, because innerMethod tries to lock again while already holding it.)
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();  // 🔒 outerMethod locks once → enters
        try {
            System.out.println("Outer method");

            // 📝 Then calls innerMethod(), which locks again (same thread, allowed).
            innerMethod();
        } finally {
            lock.unlock();  // 🔓 1st unlock for outerMethod
        }
    }

    public void innerMethod(){
        lock.lock();  // 🔒 innerMethod locks again (same thread, allowed → no deadlock)
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();  // 🔓 2nd unlock for innerMethod
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.outerMethod();
        // Output:
        // Outer method
        // Inner method
    }
}

/*
📝 Summary:
- outerMethod() locks once → enters.
- innerMethod() locks again (same thread, allowed).
- Both work fine, no deadlock.
- Unlock must match lock count → 2 lock() calls → 2 unlock() calls.
*/
