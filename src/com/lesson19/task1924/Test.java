package com.lesson19.task1924;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String s = "Это стоит 1 бакс, а вот это - 12 .\n" +
                "Переменная имеет имя file1.\n" +
                "110 - это число.";


    }
}
