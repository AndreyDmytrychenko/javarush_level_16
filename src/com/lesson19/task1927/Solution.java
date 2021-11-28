package com.lesson19.task1927;

/*
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arr);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String[] s = arr.toString().split(System.lineSeparator());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            if (i % 2 != 0) System.out.println("JavaRush - курсы Java онлайн");
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
