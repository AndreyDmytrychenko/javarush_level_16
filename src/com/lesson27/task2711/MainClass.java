package com.lesson27.task2711;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String []args) throws InterruptedException {
        Runnable task = () -> {
            try {
                System.out.println("start Main wait");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("end Main wait");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        //thread.join();
        System.out.println("Finished");

        }
    }

