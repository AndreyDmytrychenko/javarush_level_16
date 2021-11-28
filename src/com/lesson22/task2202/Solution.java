package com.lesson22.task2202;

/*
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String line = "";
        if (string==null) throw new TooShortStringException();
        String[] s = string.split(" ");
        if (s.length < 5) throw new TooShortStringException();
            line = s[1] + " " + s[2] + " " + s[3] + " " + s[4];
        return line;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
