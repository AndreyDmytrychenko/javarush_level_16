package com.lesson19.task1926;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(file));
        while (fr.ready()){
            System.out.println(new StringBuilder(fr.readLine()).reverse());
        }
        fr.close();
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt

*/