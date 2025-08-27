package com.multithreading.executorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task-1");
            return 1;
        };
        Callable callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task-2");
            return 2;
        };
        Callable callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task-3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
//        List<Future<Integer>> futures = executorService.invokeAll(list);
        List<Future<Integer>> futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
        executorService.shutdown();
        // invoke all block all task first invoke all task complete then after hello world will print
        System.out.println("Hello World");

    }
}
