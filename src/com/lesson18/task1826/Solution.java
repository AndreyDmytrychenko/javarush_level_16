package com.lesson18.task1826;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0 && args[0].equals("-e")) enCode(args[1],args[2]);
        if (args.length != 0 && args[0].equals("-d")) deCode(args[1],args[2]);

    }
    public static void enCode(String fileInName, String fileOutName) throws IOException {
        FileInputStream in = new FileInputStream(fileInName);
        FileOutputStream out = new FileOutputStream(fileOutName);
        if (!new File(fileOutName).exists()) new File(fileOutName).createNewFile();
        while (in.available() > 0) out.write(in.read()+1);
        in.close();
        out.close();
    }
    public static void deCode(String fileInName, String fileOutName) throws IOException {
        FileInputStream in = new FileInputStream(fileInName);
        FileOutputStream out = new FileOutputStream(fileOutName);
        if (!new File(fileOutName).exists()) new File(fileOutName).createNewFile();
        while (in.available() > 0) out.write(in.read()-1);
        in.close();
        out.close();
    }
}
