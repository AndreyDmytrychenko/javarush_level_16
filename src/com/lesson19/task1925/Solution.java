package com.lesson19.task1925;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<>();
        while (br.ready()) {
            String[] world = br.readLine().split(" ");
            for (String w : world) {
                if (w.length() > 6) {
                    list.add(w+",");
                }
            }
        }
        br.close();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                String s = list.get(i).replaceAll(",","");
                bw.write(s);
            } else {bw.write(list.get(i));}
        }
        bw.close();
    }
}
