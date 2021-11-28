package com.lesson22.task2211;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF8 = Charset.forName("UTF-8");
        byte[] buff = new byte[1000];
        fis.read(buff);
        fis.close();
        String s = new String(buff, windows1251);
        buff = s.getBytes(UTF8);
        fos.write(buff);
        fos.close();
    }
}
