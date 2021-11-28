package com.lesson25.task2504;

/*
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
         //implement this method - реализуйте этот метод


        for (Thread thread : threads) {
           switch (thread.getState()) {
               case NEW:
                   thread.start();
               case WAITING:
               case TIMED_WAITING:
               case BLOCKED:
                   thread.interrupt(); break;
               case RUNNABLE:
                   thread.isInterrupted(); break;
               case TERMINATED: System.out.println(thread.getPriority());
           }
        }
    }

    public static void main(String[] args) {
    }
}
