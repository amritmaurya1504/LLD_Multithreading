package com.multithreading.deadlock;

// Represents a bank account
class Account {
    private int balance;
    private final String name;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    // synchronized -> thread must acquire lock on "this" Account
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

// Transfer task (Runnable)
class Transfer implements Runnable {
    private final Account from;
    private final Account to;
    private final int amount;

    public Transfer(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Step 1: lock "from" account
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() +
                    " locked " + from.getName() + " and trying to lock " + to.getName());

            // Small sleep to force context switch and increase chance of deadlock
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            // Step 2: while holding "from", also try to lock "to" account
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);

                System.out.println(Thread.currentThread().getName() +
                        " transferred " + amount +
                        " from " + from.getName() + " to " + to.getName());
            }
        }
    }
}

public class BankAccountExample {
    public static void main(String[] args) {
        // Two accounts
        Account acc1 = new Account("Account-A", 1000);
        Account acc2 = new Account("Account-B", 2000);

        // Thread-1: tries to transfer from acc1 -> acc2
        Thread t1 = new Thread(new Transfer(acc1, acc2, 100), "Thread-1");

        // Thread-2: tries to transfer from acc2 -> acc1
        Thread t2 = new Thread(new Transfer(acc2, acc1, 200), "Thread-2");

        // Start both threads
        t1.start();
        t2.start();

        // ⚠️ Possible Deadlock Scenario:
        // - Thread-1 locks acc1, waits for acc2
        // - Thread-2 locks acc2, waits for acc1
        // => Both wait forever -> Deadlock
    }
}

