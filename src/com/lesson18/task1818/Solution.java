package com.lesson18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        reader.close();
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(f1));
        BufferedReader reader2 = new BufferedReader(new FileReader(f2));
        BufferedReader reader3 = new BufferedReader(new FileReader(f3));
        while (reader2.ready()) writer1.write(reader2.readLine());
        reader2.close();

        while (reader3.ready()) writer1.write(reader3.readLine());
        reader3.close();
        writer1.close();
    }
}
