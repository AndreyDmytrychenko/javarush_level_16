package com.lesson16.task1630;

import java.io.*;

/*
Последовательный вывод файлов
c:\Users\Андрей\Desktop\новый файл.txt
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();

        } catch (IOException e) {}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);


        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String fileContent = "";

        public void setFileName(String fullFileName) {
          this.fileName = fullFileName;
        }


        public String getFileContent() {
        return fileContent;
        }

        public void run() {
            try  {
                try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
                    String str;
                    if (reader1.ready()) {
                    while ((str = reader1.readLine()) != null) {
                        fileContent+=str+" ";
                    }
                    }
                }
            } catch (IOException e) {
                System.out.println("ошибка");
            }
        }
    }
}
