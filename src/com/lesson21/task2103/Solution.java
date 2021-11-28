package com.lesson21.task2103;

/*
Все гениальное - просто!
*/

public class Solution {
    static boolean isA = true;
    static boolean isB = true;
    static boolean isC = true;
    static boolean isD = true;

    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
      return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static boolean calculate1(boolean a, boolean b, boolean c, boolean d) {
        return ((a||!a || b||!b || d||!d) && c);
    }

    public static void main(String[] args) {
        System.out.println(calculate(isA,isB,isC,isD));
        System.out.println(calculate1(isA,isB,isC,isD));

    }
}
