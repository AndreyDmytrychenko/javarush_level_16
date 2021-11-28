package com.lesson18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(f1);
        byte[] bytesTof1 = new byte[file1.available()];
        file1.read(bytesTof1);
        file1.close();

        FileInputStream file2 = new FileInputStream(f2);
        byte[] bytesTof2 = new byte[file2.available()];
        file2.read(bytesTof2);
        file2.close();

        FileOutputStream file = new FileOutputStream(f1);
        file.write(bytesTof2);
        file.write(bytesTof1);
        file.close();

    }
}
