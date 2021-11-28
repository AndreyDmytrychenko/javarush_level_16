package com.lesson16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            List<Integer> list = new ArrayList<>();
            String str = "";
            int sum = 0;
            try {
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(in);
                while (true) {
                    str = reader.readLine();
                    try {
                        list.add(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                        if (str.equals("N")) {
                            reader.close();
                            in.close();
                            for (Integer integer : list) {
                                sum += integer;
                            }
                            System.out.println(sum);
                            break;
                        }
                    }

                }

            } catch (IOException e) {
            }
        }
    }

        public static List<Thread> threads = new ArrayList<>(5);

        static {
            threads.add(new Thread1());
            threads.add(new Thread2());
            threads.add(new Thread3());
            threads.add(new Thread4());
            threads.add(new Thread5());
        }

        public static void main(String[] args) throws InterruptedException {
            threads.get(4).start();
            threads.get(4).join();
            for (int i = threads.size() - 2; i >= 0; i--) {
                threads.get(i).start();
            }
        }
    }





