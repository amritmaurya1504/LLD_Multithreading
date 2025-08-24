package com.multithreading.synchronization;


/* synchronized lock lga deta hai wo v intrinsic lock which is automatic lock we can't control that
* but explicit lock is the type of lock which we can control and we can define when to lock and when to unlock
* */

public class Counter {
    private int count = 0;

    // Critical Condition (Shared resource)
    public synchronized void increment(){
        /*synchronized (this){ // at a time only one thread can increase the value
            count++;
        }*/
        count++;
    }

    public int getCount(){
        return this.count;
    }
}
