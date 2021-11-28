package com.lesson16.task1525;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        initList(lines);
    }

    public static void main(String[] args) {

        System.out.println(lines);
    }

    public static List<String> initList(List<String> list) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader
                (new FileInputStream(Statics.FILE_NAME), StandardCharsets.UTF_8))){
            String str;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
