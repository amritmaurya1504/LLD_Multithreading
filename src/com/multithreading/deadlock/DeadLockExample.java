package com.multithreading.deadlock;

/*
* ✅ Real way to remove deadlock

The fix is: always acquire locks in a consistent order.
For example: always lock Pen first, then Paper in both threads.
* */

// Pen class
class Pen {
    // synchronized -> lock is acquired on the Pen object
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() +
                " is using pen " + this + " and trying to use paper " + paper);

        // Here, while holding the Pen lock,
        // it calls paper.finishWriting() which is synchronized.
        // So this thread now tries to acquire Paper lock → possible deadlock.
        paper.finishWriting();
    }

    // synchronized -> lock acquired on this Pen
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() +
                " finished using pen " + this);
    }
}

// Paper class
class Paper {
    // synchronized -> lock acquired on the Paper object
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() +
                " is using paper " + this + " and trying to use pen " + pen);

        // Here, while holding the Paper lock,
        // it calls pen.finishWriting() which is synchronized.
        // So this thread now tries to acquire Pen lock → possible deadlock.
        pen.finishWriting();
    }

    // synchronized -> lock acquired on this Paper
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() +
                " finished using paper " + this);
    }
}

// Runnable Task1
class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() +
                        " writing with pen and paper");
            }
        }
    }
}

// Runnable Task2
class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() +
                        " writing with pen and paper");
            }
        }
    }
}

// Main class
public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        // Thread-1: Locks Pen -> then tries Paper
        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");

        // Thread-2: Locks Pen (via synchronized block) -> then tries Paper
        // Meanwhile inside Paper method -> tries Pen again
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");

        thread1.start();
        thread2.start();

        // ❌ This design can cause Deadlock because:
        // Thread-1 holds Pen and waits for Paper
        // Thread-2 holds Paper and waits for Pen
        // Both wait forever.
    }
}
