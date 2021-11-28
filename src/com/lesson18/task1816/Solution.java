package com.lesson18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[] {"c:/Users/Андрей/Desktop/файл.txt"};
        String alp =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet = alp.toCharArray();
        if (args[0].length()>0){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            List<String> list = new ArrayList<>();
            while (reader.ready()) list.add(reader.readLine());
            reader.close();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                for (char ch : list.get(i).toCharArray()) {
                    for (char al : alphabet) {
                        if (ch == al) count++;
                    }
                }
            }
            System.out.println(count);

    }
}

}
