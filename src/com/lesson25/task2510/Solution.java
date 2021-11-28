package com.lesson25.task2510;



public class Solution extends Thread  {
    public Solution() {
        this.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String massage;
                if (e instanceof Error) {massage = "Нельзя дальше работать";}
                else if (e instanceof Exception) {massage = "Надо обработать";}
                else massage = "Поживем - увидим";
                System.out.println(massage);
            }
        });
    }

    @Override
    public void run() {
        super.run();
        try {

            throw new Error();

        } catch (Throwable e) {
            getUncaughtExceptionHandler().uncaughtException(this, e);
        }
    }

    public static void main(String[] args)  {

     new Solution().start();
    }
}
