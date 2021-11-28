package com.lesson16.task1617;

/*
Отсчет на гонках
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile int numSeconds = 10;

    public static void main(String[] args) throws InterruptedException {

        //add your code here - добавь код тут
       RacingClock clock = new RacingClock();
        Thread.sleep(3500);
            clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут

            while (!isInterrupted()) {

                    System.out.print(numSeconds-- + " ");
                try {
                    Thread.sleep(1000);
                    if (numSeconds == 0) {
                        System.out.print("Марш!");
                      break;
                }
                } catch (InterruptedException e) {
                    System.out.print("Прервано!");
                    break;
                }
            }
        }
    }
}

