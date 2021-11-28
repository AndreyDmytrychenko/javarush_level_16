package com.lesson19.task1910;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader re = new BufferedReader(new FileReader(file1));
        BufferedWriter wr = new BufferedWriter(new FileWriter(file2));
        ArrayList<String> list = new ArrayList<>();
        String line = "";
        while ((line = re.readLine()) != null) {
            String[] str = line.split(" ");
            for (String s : str){
                String string = s.replaceAll("[\\W|\\n]","");
                wr.write(string + " ");
            }
        }
        re.close();
        wr.close();
    }

}
/*
c:\Users\Андрей\Desktop\файл.txt
c:\Users\Андрей\Desktop\новый файл.txt
*/
