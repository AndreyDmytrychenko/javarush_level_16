package com.lesson26.task2606;

public class Main {
    public static String str = "Hello World";
    public static void main(String[] args) {
        System.out.println(changeStr(str));
    }
    public static String changeStr(String s) {
        System.out.println(s);
        s = "Hello";
        return s;
    }

}
