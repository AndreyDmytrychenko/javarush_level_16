package com.lesson16.task1619;


public class Solution {
    public static volatile boolean isStop = false;
    public static void main(String[] args) throws InterruptedException {

        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(3000);
        testThread.interrupt();
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
     isStop = true;
    }

    public static class TestThread extends Thread implements Runnable {


        public void run() {
            while (!isStop) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Программа прервана!");
                }
            }
            System.out.println("Цикл прерван!");
        }
    }
}


