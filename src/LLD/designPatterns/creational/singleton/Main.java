package LLD.designPatterns.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        /*
            TVSet tvSet1 = TVSet.getTvSetInstance();
            TVSet tvSet2 = TVSet.getTvSetInstance();
            TVSet tvSet3 = TVSet.getTvSetInstance();
            System.out.println(tvSet1.hashCode());
            System.out.println(tvSet2.hashCode());
            System.out.println(tvSet3.hashCode());
        */

        // Execution in multithreading environment
        /*
        It creates a thread pool with a fixed number of threads (n). This means:
            It can execute up to n threads concurrently.
            If more tasks are submitted than threads available, extra tasks will wait in a queue until a thread becomes free.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(TVSet::getTvSetInstance);
        executorService.execute(TVSet::getTvSetInstance);
        executorService.execute(TVSet::getTvSetInstance);
        executorService.execute(TVSet::getTvSetInstance);
        executorService.execute(TVSet::getTvSetInstance);

    }
}
