package com.lesson22.task2203;

/*
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int a=0,b=0;
        if (string==null) throw new TooShortStringException();
        a = string.indexOf("\t") + 1;
        b = string.indexOf("\t", a);
        if (b < 0) throw new TooShortStringException();



        return string.substring(a,b);

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }


}
