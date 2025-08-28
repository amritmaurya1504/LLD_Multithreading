package com.multithreading.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> System.out.println("Task executed after 5 second delay !"),
                2,
                TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Task executed after 5 second delay !"),
                3,
                1,
                TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task executed after 5 second delay !"),
                3,
                5,
                TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown.....");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);

    }
}
