package com.lesson19.task1906;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader re = new FileReader(file1);
        ArrayList<Integer> list =  new ArrayList<>();
        while (re.ready()) list.add(re.read());
        re.close();
        FileWriter wr = new FileWriter(file2);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) wr.write(list.get(i));
        }
        wr.close();



    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
c:\Users\Андрей\Desktop\новый файл.txt
 */
