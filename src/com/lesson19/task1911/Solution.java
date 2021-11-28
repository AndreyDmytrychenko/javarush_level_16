package com.lesson19.task1911;

import java.io.*;

/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        String str = outputStream.toString();
        System.setOut(consoleStream);

        System.out.println(str.replaceAll("\\D",""));
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt
*/
