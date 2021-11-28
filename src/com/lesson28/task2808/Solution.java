package com.lesson28.task2808;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            Future future = executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }
        Thread.sleep(100);
        for (Runnable runnable : executor.shutdownNow()) {
            System.out.printf("%s was not completed \n",(runnable.toString().split("\\["))[0]);

        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

