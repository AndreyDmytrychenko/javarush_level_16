package com.lesson18.task1805;

import java.io.*;
import java.util.*;

public class Solution {

    public String fileName;

    public static void main(String[] args) {
        com.lesson18.task1804.Solution sol = new com.lesson18.task1804.Solution();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            sol.fileName = reader.readLine();
        } catch (IOException e) {}

        try (InputStream inputStream = new FileInputStream(sol.fileName)){
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                list.add(data);
            }
        } catch (IOException e) {}

        for (int data : list) set.add(data);

        for (int data : set) System.out.print(data + " ");
    }
}
