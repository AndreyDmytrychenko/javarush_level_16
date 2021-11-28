package com.lesson18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{"c:/Users/Андрей/Desktop/файл.txt"};
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            List<String> list = new ArrayList<>();
            while (reader.ready()) list.add(reader.readLine());
            double countP = 0;
            double countS = 0;
            for (int i = 0; i < list.size(); i++) {
                char[] chars = list.get(i).toCharArray();
                for (char ch : chars) {
                    if (ch == ' ') countP++;
                    else countS++;
                }
            }
            reader.close();
            double allVal = countP+countS;
            double res = countP/allVal*100;
            System.out.printf(Locale.ENGLISH,"%.2f",res);


        }

    }
}
