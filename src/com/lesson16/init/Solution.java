package com.lesson16.init;

public class Solution {
    static {
        init();
    }

    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";


    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();


    }

    public static void printAllFields(Solution obj) {
        String static_void_printAllFields = "static void printAllFields";

        System.out.println(static_void_printAllFields);

        System.out.println(obj.i);
        System.out.println(obj.name);

    }
}