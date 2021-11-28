package com.lesson19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader re = new BufferedReader(new FileReader(file1));
        ArrayList<String> list = new ArrayList<>();
        String line = "";
        while ((line = re.readLine()) != null) {
            String[] str = line.split(" ");
            for (String s : str) list.add(s);
        }
        re.close();
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я\\D]");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) iterator.remove();
            if (str.isEmpty()) iterator.remove();
        }
//        for (String str: list) {
//            Matcher matcher = pattern.matcher(str);
//            if (matcher.find()) list.remove(str);
//            if (str.isEmpty()) list.remove(str);
//        }

        for (String s : list) System.out.print(s+" ");
        BufferedWriter wr = new BufferedWriter(new FileWriter(file2));
        for (String s : list) wr.write(s + " ");
        wr.close();
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt
c:\Users\Андрей\Desktop\новый файл.txt
 */