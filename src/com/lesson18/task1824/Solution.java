package com.lesson18.task1824;

import java.io.*;

public class Solution {
    public static volatile boolean isStop = false;
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (!isStop) new FileReader(reader.readLine()).start();
        } catch (IOException e) {}
    }
    public static class FileReader extends Thread {
        String fileName;
        public FileReader(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
                try (FileInputStream in = new FileInputStream(fileName)) {
                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    isStop = true;
            } catch (IOException e) {}
        }
    }
}
//c:\Users\Андрей\Desktop\файл.txt