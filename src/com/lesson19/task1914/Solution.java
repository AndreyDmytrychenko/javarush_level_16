package com.lesson19.task1914;

import java.io.*;


/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)  {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        String str = outputStream.toString();
        System.setOut(consoleStream);

        String[] exp = str.split(" ");
        if ("+".equals(exp[1])) System.out.printf("%s %s %s %s %d",exp[0],exp[1],exp[2],exp[3],Integer.parseInt(exp[0]) + Integer.parseInt(exp[2]));
        if ("-".equals(exp[1])) System.out.printf("%s %s %s %s %d",exp[0],exp[1],exp[2],exp[3],Integer.parseInt(exp[0]) - Integer.parseInt(exp[2]));
        if ("*".equals(exp[1])) System.out.printf("%s %s %s %s %d",exp[0],exp[1],exp[2],exp[3],Integer.parseInt(exp[0]) * Integer.parseInt(exp[2]));

    }
    public static class TestString {
        public void printSomething() {
            System.out.println("77 - 654 = ");
        }
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt
*/
