package com.lesson18.task1801;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static String fileName;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {}

       try (InputStream inputStream = new FileInputStream(fileName)){
           while (inputStream.available() > 0) {
               int data = inputStream.read();
               list.add(data);
           }
        } catch (IOException e) {}
        Collections.sort(list);

       System.out.println(list.get(list.size()-1));
    }
}
