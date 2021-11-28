package com.lesson18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String fileName;
    while (!(fileName = reader.readLine()).equals("exit")) {
        new ReadThread(fileName);
    }
    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            this.start();
        }

        public void run() {
            int[] bites = new int[256];
            List<Integer> list = new ArrayList<>();
            try(FileInputStream in = new FileInputStream(fileName)) {
                while (in.available() > 0) {
                    bites[in.read()]++;
                }
            } catch (IOException e) {}
            for (int i : bites) list.add(i);
            Collections.sort(list);

            int max = list.get(list.size() - 1);
            int b = 0;
            for (int i = 0; i < bites.length; i++) {
                if (max == bites[i]) b = i;
            }
            resultMap.put(fileName, b);
            }
        }
    }


