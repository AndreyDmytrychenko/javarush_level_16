package com.lesson29.task2913;

import java.util.Random;

/*
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String res = "";
        if (a > b) {
            for (int i = a; i >= b; --i) {
                if (i == b) {
                    res += i;
                } else {
                    res += i + " ";
                }
            }

        } else {
            if (a == b) {
                res += Integer.toString(a);
            }
            for (int i = a; i <= b; ++i) {
                if (i == b) {
                    res += i;
                } else {
                    res += i + " ";
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}

