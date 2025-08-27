package com.multithreading.lambdaExpression;

/*
 * Lambda Expression is an anonymous function (a function without a name).
 * In Java, it is often used to implement functional interfaces (interfaces with a single abstract method).
 * Here, we are using it to implement the Runnable interface in a concise way.
 */

public class LambdaExpression {
    public static void main(String[] args) {

        // ✅ Using Lambda Expression to create a Runnable
        // Runnable is a Functional Interface (only one abstract method: run()).
        // Instead of writing an anonymous inner class, we use () -> { }.
        // This means: when run() is called, it will execute System.out.println("Hello");
        Runnable runnable = () -> System.out.println("Hello");

        // ✅ Creating a Thread and passing the runnable task
        // Thread will execute the run() method of the Runnable when started.
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(() -> System.out.println("Hello World!"));

        // ✅ Starting the thread
        // This internally calls the run() method of our Runnable implementation.
        t1.start();
        t2.start();


        Student engineeringStudent = (name) -> {
            return name + " is engineering student";
        };

        Student lawStudent = name -> name + " is law student";

        System.out.println(lawStudent.getBio("Soni"));
        System.out.println(engineeringStudent.getBio("Amrit"));
    }
}
