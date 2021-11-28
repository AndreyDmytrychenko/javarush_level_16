package com.lesson27.task2708;

import java.util.ArrayList;
import java.util.List;

public class Main1 {



    public static void main(String[] args) {

        BlockingQueue blockingQueue = new BlockingQueue();


        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    Runnable task = blockingQueue.getTask();
                    task.run();



                }
            }
        });
        workThread.start();

        for (int i = 0; i < 1; i++) {
            blockingQueue.put(get());
        }



    }

    public static Runnable get() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Start: " + this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("End: " + this);
            }
        };
    }
}

    class BlockingQueue {

        List<Runnable> tasks = new ArrayList<>();

        public synchronized Runnable getTask()  {
            while (tasks.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Runnable task = tasks.get(0);
            tasks.remove(task);
            return task;
        }

        public synchronized void put(Runnable task) {
            tasks.add(task);
            notify();
        }
    }

