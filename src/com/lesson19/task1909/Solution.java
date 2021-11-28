package com.lesson19.task1909;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader re = new BufferedReader(new FileReader(file1));
        BufferedWriter wr = new BufferedWriter(new FileWriter(file2));
        String line = "";
        while ((line = re.readLine()) != null) {
            String str = line.replaceAll("[\\.]","!");
            wr.write(str);
        }

        wr.close();
        re.close();
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
c:\Users\Андрей\Desktop\новый файл.txt
*/
