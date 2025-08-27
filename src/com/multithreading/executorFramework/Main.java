package com.multithreading.executorFramework;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
         * -------------------------
         * 1. Using SingleThreadExecutor
         * -------------------------
         * - Creates an ExecutorService with only ONE thread.
         * - Tasks are executed sequentially (one after another).
         * - submit() returns a Future object, which can hold the result of the task.
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submitting a Callable task (returns a result "42")
        Future<Integer> future = executorService.submit(() -> 42);
        Future<String> submit = executorService.submit(() -> System.out.println("Hello"), "success");

        // future.get() blocks until the result is available
        System.out.println(future.get()); // prints 42
        System.out.println(submit.get());

        // Always shutdown an executor to release resources
        executorService.shutdown();
        System.out.println(executorService.isTerminated());



        /*
         * -------------------------
         * 2. Using FixedThreadPool
         * -------------------------
         * - Creates a pool of N threads (here N = 9).
         * - At most 9 tasks can run in parallel.
         * - Extra tasks (if any) are kept in a queue until a thread is free.
         * - Here, we calculate factorials of numbers 1 → 9.
         */
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(9);

        for (int i = 1; i < 10 ; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }

        // Prevents new tasks from being submitted
        executor.shutdown();

        try {
            // Wait up to 100 seconds for all tasks to complete
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total time (ExecutorService): " +
                (System.currentTimeMillis() - startTime));



        /*
         * -------------------------
         * 3. Using Plain Threads (without ExecutorService)
         * -------------------------
         * - Here we manually create 9 threads to compute factorials.
         * - Each thread is started explicitly.
         * - Then we call join() on each thread to wait for completion.
         * - This approach works, but is harder to manage if there are
         *   many tasks (e.g., hundreds or thousands).
         * - ExecutorService simplifies this by managing thread lifecycle
         *   and queueing internally.
         */

        /*
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];

        for (int i = 1; i < 10 ; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i - 1].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total time (Plain Threads): " +
                (System.currentTimeMillis() - startTime));
        */


        /*
         * -------------------------
         * 4. Sequential Execution (no threads)
         * -------------------------
         * - Factorials are calculated one by one in the main thread.
         * - Takes the most time because no parallelism is used.
         * - Demonstrates why multithreading or thread pools improve performance.
         */

        /*
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 10 ; i++) {
            System.out.println(factorial(i));
        }
        System.out.println("Total time (Sequential): " +
                (System.currentTimeMillis() - startTime));
        */
    }


    /*
     * Factorial method with artificial delay:
     * - Thread.sleep(1000) simulates a time-consuming task (like DB call or I/O).
     * - Each factorial calculation takes about 1 second.
     * - With multithreading, multiple factorials can be computed in parallel,
     *   reducing total execution time.
     */
    public static long factorial(int n){
        try {
            Thread.sleep(1000); // simulate heavy computation
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
}
