package com.lesson18.task1808;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int a = inputStream.available();

        //1 файл
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[(a + 1) / 2];

        int count = inputStream.read(buffer);

        outputStream.write(buffer, 0, count);
        outputStream.close();

        //2 файл
        outputStream = new FileOutputStream(reader.readLine());
        buffer = new byte[a / 2];

        count = inputStream.read(buffer);

        outputStream.write(buffer, 0, count);
        outputStream.close();


        inputStream.close();
    }
}
// d:\JDK-intellij-downloader-info.txt
// c:\Users\Андрей\Desktop\файл.txt
// c:\Users\Андрей\Desktop\новый файл.txt