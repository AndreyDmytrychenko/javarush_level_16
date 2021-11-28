package com.lesson18.task1825;


import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            while (!(str = reader.readLine()).equals("end")) {
                set.add(str);
            }
        } catch (IOException e) {}
        FileOutputStream fos = new FileOutputStream(set.first().substring(0, set.first().lastIndexOf(".part")));
            for (String s : set) {
                FileInputStream fis = new FileInputStream(s);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fos.write(buffer);
                fis.close();
            }
            fos.close();
    }
}
