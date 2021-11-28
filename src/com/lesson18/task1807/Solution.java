package com.lesson18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(reader.readLine())))) {
                String str;
                while ((str = fileReader.readLine()) != null) {
                    list.add(str);
                }
            }
            } catch (IOException e) {
            }
        int count = 0;
        char c = ',';
        for (String data : list) {
            for (char ch : data.toCharArray()){
                if (c == ch) count++;
            }
        }
        System.out.println(count);
        }
    }
// d:\JDK-intellij-downloader-info.txt
// c:\Users\Андрей\Desktop\файл.txt