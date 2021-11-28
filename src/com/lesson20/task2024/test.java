package com.lesson20.task2024;

public class test {
    public static void main(String[] args) {
        int c = 1634;
        int st = String.valueOf(c).length();
        char[] chars = String.valueOf(c).toCharArray();
        int sum = 0;
        for (char ch : chars) {
            int r = Integer.parseInt((String.valueOf(ch)));
            for (int w = 1; w < st; w++) {
            r *= Integer.parseInt((String.valueOf(ch)));
            }
            sum+=r;
        }
        System.out.println(sum);
    }
}
