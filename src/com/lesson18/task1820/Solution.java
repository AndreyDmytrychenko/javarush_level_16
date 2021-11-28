package com.lesson18.task1820;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        BufferedReader re = new BufferedReader(new FileReader(f1));
        BufferedWriter wr = new BufferedWriter(new FileWriter(f2));
        while (re.ready()) {
            String[] str = re.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                wr.write(Math.round(Double.parseDouble(str[i]))+" ");
            }
        }
        re.close();
        wr.close();

    }
}

