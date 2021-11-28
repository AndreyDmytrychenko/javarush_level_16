package com.lesson18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        FileInputStream stream;
        do {
            stream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } while (stream.available() > 999);
        stream.close();
        throw new DownloadException();

    }
    public static class DownloadException extends Exception {

    }
}
// d:\JDK-intellij-downloader-info.txt
// c:\Users\Андрей\Desktop\новый файл.txt
// c:\Users\Андрей\Desktop\файл.txt