package com.lesson27.task2711;
/*
CountDownLatch
*/

import java.util.concurrent.CountDownLatch;

public class Solution {

    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {

            retrieveValue();
            latch.await();
            isWaitingForValue = false;

    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        solution.someMethod();
        System.out.println(solution.isWaitingForValue);
    }
}

