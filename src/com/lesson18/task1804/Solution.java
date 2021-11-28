package com.lesson18.task1804;

import java.io.*;
import java.util.*;

public class Solution {

    public String fileName;

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> list = new ArrayList<>();
        List<Integer> listSortMapValue = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
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
        int countMap = 0;
        for (int data : set) {
            for (int i = 0; i < list.size(); i++) {
                if (data == list.get(i)) {
                    countMap++;
                }
                map.put(data,countMap);
            }
            countMap = 0;
        }
        for (Map.Entry<Integer,Integer> data : map.entrySet()) {
            listSortMapValue.add(data.getValue());
        }
        Collections.sort(listSortMapValue);
        for (Map.Entry<Integer,Integer> data : map.entrySet()) {
            if (data.getValue().equals(listSortMapValue.get(0))) {
                System.out.print(data.getKey() + " ");
            }
        }
    }
}

// d:\JDK-intellij-downloader-info.txt
