package com.lesson19.task1923;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        while (br.ready()) {
            String[] line = br.readLine().split(" ");
            for (String s : line) {
                if (s.matches(".*[0-9]+.*")) bw.write(s+" ");
            }
        }
        br.close();
        bw.close();
    }
}
