package com.lesson18.task1803;
import java.io.*;
import java.util.*;

public class Solution {
    public static String fileName;
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> listSortMapValue = new ArrayList<>();
    public static Map<Integer, Integer> map = new HashMap<>();
    public static Set<Integer> set = new HashSet<>();

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
            if (data.getValue().equals(listSortMapValue.get(listSortMapValue.size()-1))) {
                System.out.print(data.getKey() + " ");
            }
        }
    }
}

// d:\JDK-intellij-downloader-info.txt