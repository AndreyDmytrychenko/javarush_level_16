package com.lesson18.task1821;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{"c:/Users/Андрей/Desktop/файл.txt"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[0]));
        writer.write(reader.readLine());
        reader.close();
        writer.close();
        System.out.println(Integer.MIN_VALUE);
        int[] chars = new int[256];
        if (args.length > 0) {
            FileInputStream in = new FileInputStream(args[0]);
            while (in.available() > 0) {
                chars[in.read()]++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    System.out.println(i + " " + (char) i + " " + chars[i]);
                }
            }
        }
    }
}