package com.lesson19.task1903;

public class Test {
    public static void main(String[] args) {
        int n = 36;
        int p = 2;
        int r = 1123775567;
        int code = 38;
        String num = String.format("%010d",r);
        String line = String.format("+%d(%s)%s-%s-%s",code, String.valueOf(num.substring(0,3)), String.format(num.substring(3,6)),
                String.format(num.substring(6,8)), String.format(num.substring(8,10)));
        System.out.println(line);
    }
}
