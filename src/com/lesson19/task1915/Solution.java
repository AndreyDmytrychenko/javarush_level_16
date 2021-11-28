package com.lesson19.task1915;

import java.io.*;

/*
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String fileName = re.readLine();
        re.close();
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();
        String str = outputStream.toString();
        System.setOut(consoleStream);
        FileOutputStream fops = new FileOutputStream(fileName);
        outputStream.writeTo(fops);//метод для записи в поток записи
        //fops.write(str.getBytes());
        fops.close();
        outputStream.writeTo(System.out);
        //System.out.println(str);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing 99655");
        }
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt
*/

