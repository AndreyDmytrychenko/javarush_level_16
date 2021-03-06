package com.lesson19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(file));
        while (fr.ready()) {
            String s = fr.readLine();
            for (int i = 12; i >= 0; i--) {
            s = s.replaceAll("\\b"+i+"\\b", map.get(i));
            }
            System.out.println(s);
        }
        fr.close();
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
*/
