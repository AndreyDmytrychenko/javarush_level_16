package com.lesson19.task1905;

public class Test {
    public static void main(String[] args) {
        String n = "988(7 373??) gdgg*89";

        String r = n.replaceAll("[\\w+gg]","");

        System.out.println(r);
    }
}
