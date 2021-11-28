package com.lesson19.task1907;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        ArrayList<Character> list = new ArrayList<>();
        FileReader re = new FileReader(file);
        while (re.ready()) {
            char ch = (char) re.read();
            list.add(ch);
        }
        re.close();
        String s = "";
        for (char ss : list) s += ss;
        int count = 0;
         String line = s.replaceAll("[\\W]"," ");
        String[] str = line.split(" ");

            for (String ss : str) {
                if ("world".equals(ss)) count++;
            }
        System.out.println(line);
        System.out.println(count);
        }
    }

/*
c:\Users\Андрей\Desktop\файл.txt
c:\Users\Андрей\Desktop\новый файл.txt
 */