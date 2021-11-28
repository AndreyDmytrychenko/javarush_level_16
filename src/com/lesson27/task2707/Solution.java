package com.lesson27.task2707;

/*
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {

        Thread myThread1 = new Thread( () -> {
                synchronized (o1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {}
                }
        });

        Thread myThread2 = new Thread( () -> {
            solution.someMethodWithSynchronizedBlocks(o1, o2);
        });

        myThread1.start();
        myThread2.start();
        Thread.sleep(2000);

       if (myThread2.getState() != Thread.State.BLOCKED) return true;
       else return false;

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));

    }
}

