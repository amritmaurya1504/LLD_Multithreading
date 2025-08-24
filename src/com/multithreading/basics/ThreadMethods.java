package com.multithreading.basics;

/*Thread Methods
* 1. Start
* 2. run
* 3. sleep
* 4. join
* 5. SetPriority() it is just a hint ---> In Java multithreading, Thread.setPriority() is just a hint to the thread scheduler (JVM + OS).
It does not guarantee execution order. The actual scheduling is controlled by the Operating System’s thread scheduler, and different OS/JVMs handle priorities differently.
* 6. Interrupt
* 7. Yield -- Har iteration ke baad dusra banda ko chance de do schedular bhai (hint hai bas)
* 8. setDaemon -- background me chalega aisa threads jvm wait nhe karega iska
* */

public class ThreadMethods extends Thread {

    /*public ThreadMethods(String name){
        super(name);
    }*/

    @Override
    public void run() {

        while (true){
            System.out.println("Hello World!");
        }

        /*for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }*/

        /*try{
            Thread.sleep(1000);
            System.out.println("Thread is running...........");
        }catch (InterruptedException e){
            System.out.println("Thread interrupted : " + e);
        }*/

        /*for (int i = 0; i < 5 ; i++) {
            String a = "";
            for (int j = 0; j < 10000 ; j++) {
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " +
                    Thread.currentThread().getPriority() + " - Count: " + i);

           try{
                Thread.sleep(10);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }*/



        /*System.out.println("Thread is runnning.............");
        for (int i = 0; i < 5 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }*/
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods threadMethods1 = new ThreadMethods();
        ThreadMethods threadMethods2 = new ThreadMethods();
        threadMethods1.setDaemon(true);
        threadMethods1.start();
        threadMethods2.start(); // User Thread JVM Wait karega iska khatam hone ka
        System.out.println("Main Done!");


        /*threadMethods1.interrupt();*/

        /*ThreadMethods threadMethods2 = new ThreadMethods("Medium Priority Thread");
        ThreadMethods threadMethods3 = new ThreadMethods("Low Priority Thread");
        threadMethods1.setPriority(Thread.MAX_PRIORITY);
        threadMethods2.setPriority(Thread.NORM_PRIORITY);
        threadMethods3.setPriority(Thread.MIN_PRIORITY);
        threadMethods1.start();
        threadMethods2.start();
        threadMethods3.start();*/


        /*threadMethods.join();
        System.out.println(threadMethods.getState());*/
    }
}
