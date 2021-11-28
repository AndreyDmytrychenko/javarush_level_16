package com.lesson16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        //add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        public volatile String str = "";
        List<String> list = new ArrayList<String>();
        public void printResult() {
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
        public void run() {
            synchronized (reader) {
            for (int i = 0; i < 3; i++) {
                try {
                        str = reader.readLine();
                        list.add(str);
                } catch (IOException e) {
                    e.printStackTrace();
                 }
               }
            }
        }
    }
}

