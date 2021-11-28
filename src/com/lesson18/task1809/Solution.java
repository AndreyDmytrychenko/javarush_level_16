package com.lesson18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[fileInputStream.available()];
        byte[] buffRevers = new byte[fileInputStream.available()];
        List<Byte> listByte = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
        }
        for (int i = 0; i < buffer.length; i++) System.out.print(buffer[i] + " ");//

        for (int i = buffer.length-1; i >= 0; i--) {
            listByte.add(buffer[i]);
        }
        System.out.println();//
        for (byte b : listByte) System.out.print(b + " ");//
        for (int i = 0; i < listByte.size(); i++) {
            buffRevers[i] = listByte.get(i);
        }
        System.out.println();//
        for (int i = 0; i < buffRevers.length; i++) System.out.print(buffRevers[i] + " ");//
        fileOutputStream.write(buffRevers);

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
// d:\JDK-intellij-downloader-info.txt
// c:\Users\Андрей\Desktop\файл.txt