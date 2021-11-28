package com.lesson19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String file = re.readLine();
        re.close();

        BufferedReader fr = new BufferedReader(new FileReader(file));
        while (fr.ready()) {
            String s = fr.readLine();
            int count = 0;
            for (String p : words) {
                Matcher m = Pattern.compile("\\b" + p + "\\b").matcher(s);
                if (m.find()) ++count;
            }
                if (count == 2) {System.out.println(s);}
                count = 0;
        }
        fr.close();
    }
}

