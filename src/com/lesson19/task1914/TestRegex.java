package com.lesson19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static TestString testString = new TestString();

    public static void main(String[] args)  {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        String str = outputStream.toString();


        Matcher m = Pattern.compile("(\\d+) ([\\+\\-\\*]) (\\d+)").matcher(str);
        String result = "";
        m.find();
        System.out.println(m.group(3));
        switch (m.group(2)) {
            case "+": {
                result = String.format("%s + %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) + Integer.parseInt(m.group(3)));
                break;
            }
            case "-": {
                result = String.format("%s - %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) - Integer.parseInt(m.group(3)));
                break;
            }
            case "*": {
                result = String.format("%s * %s = %d", m.group(1), m.group(3), Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(3)));
                break;
            }
        }
        System.setOut(consoleStream);
        System.out.println(result);

    }
    public static class TestString {
        public void printSomething() {

            System.out.println("743 - 233 = ");
        }
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt
*/

