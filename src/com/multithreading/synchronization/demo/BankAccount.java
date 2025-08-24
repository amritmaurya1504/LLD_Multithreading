package com.multithreading.synchronization.demo;

// 📝 Here we will use an explicit lock (ReentrantLock) to control access to balance
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    // 📝 ReentrantLock allows us to explicitly lock/unlock
    // unlike "synchronized", we have more control (like tryLock with timeout).
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() +
                " attempting to withdraw " + amount);

        try {
            // 📝 tryLock(2000, TimeUnit.MILLISECONDS)
            // → wait up to 2 seconds to get the lock
            // → if not acquired, return false
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {

                // 📝 If lock acquired, check balance
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() +
                            " proceeding with withdrawal");
                    try {
                        // 📝 Simulate long-running process (10 seconds)
                        // This makes other threads wait for the lock
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        // 📝 If thread is interrupted while sleeping,
                        // restore the interrupt flag so higher-level code knows
                        Thread.currentThread().interrupt();
                    } finally {
                        // 📝 Always unlock inside finally
                        // (so even if error happens, lock is released)
                        lock.unlock();
                    }

                    // 📝 Deduct amount after finishing process
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() +
                            " completed withdrawal. Remaining balance: " + this.balance);
                } else {
                    // 📝 If not enough balance
                    System.out.println(Thread.currentThread().getName() +
                            " insufficient balance");
                }
            } else {
                // 📝 If lock not acquired within 2 seconds
                System.out.println(Thread.currentThread().getName() +
                        " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            // 📝 If any unexpected exception, restore interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

/*
📝 Summary:
- Each thread tries to withdraw money.
- They call tryLock(2s):
   ✅ If one thread has the lock, the other waits up to 2s.
   ❌ If still locked after 2s, it gives up ("could not acquire lock").
- Only one thread can do withdrawal at a time.
- Balance updates safely because lock prevents race conditions.
- Always use unlock() inside finally so lock is not stuck forever.
*/
