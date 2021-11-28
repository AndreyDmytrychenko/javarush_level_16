package com.lesson16.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String line = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            line = reader.readLine();
        } catch (IOException e) {
        }
        String[] str = sortLine(line);
        String[] copy = str.clone();
        printArray(copy);
        System.out.println();
        printAlert(str);
    }
    public static String[] sortLine(String line) {

            String text = "";
            String[] str = line.split("\\?");
            String[] str1 = str[1].split("&"); // lvl=1 view name=Amigo
            for (String s : str1) text += s + " ";
            String[] str2 = text.split("=");
            text = "";
            for (String s : str2) text += s + " ";
            String[] str3 = text.split(" ");
            List list = new ArrayList();
            for (String s : str3) list.add(s);
            list.remove(list.size() - 1);
            text = "";
            for (Object s : list) text += s + " ";
            String[] str4 = text.split(" ");
            return str4;
    }

    public static void printArray(String[] str) {
        List<String> list = new ArrayList<>();

        for (String s : str) list.add(s);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("lvl")) {
                list.remove(list.get(i + 1));
            } else if (list.get(i).equals("obj")) {
                list.remove(list.get(i + 1));
            }
        }
        for (String s : list) System.out.print(s+" ");
    }

     public static void printAlert(String[] str) {
         List<String> list = new ArrayList<>();

         for (String s : str) list.add(s);
         for (int i = 0; i < list.size(); i++) {
             if (list.get(i).equals("lvl")) {
                 list.remove(list.get(i + 1));
             } else if (list.get(i).equals("obj")) {
                 try {
                     alert(Double.parseDouble(list.get(i + 1)));
                 } catch (Exception e) {
                     alert(list.get(i + 1));
                 }
                 list.remove(list.get(i + 1));
             }
         }
     }
        public static void alert ( double value){
            System.out.println("double: " + value);
        }

        public static void alert (String value){
            System.out.println("String: " + value);
        }
    }
