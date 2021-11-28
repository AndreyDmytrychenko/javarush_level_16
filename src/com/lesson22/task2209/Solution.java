package com.lesson22.task2209;

/*
Составить цепочку слов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();

        BufferedReader fr = new BufferedReader(new FileReader(file));

        String[] s = null;
        while (fr.ready()) {
            s = fr.readLine().split(" ");
        }
        fr.close();

        StringBuilder result = getLine(s);
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {

        StringBuilder sb = new StringBuilder();
        if (words == null) return sb;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        sb.append(list.get(0));

        for (int i = 0; i < list.size(); i++) {

            if (Character.toString(sb.charAt(sb.length() - 1))
                    .equalsIgnoreCase(Character.toString(list.get(i).charAt(0)))) {
                sb.append(" " + list.get(i));
                list.remove(i);
                i=0;
            }
        }
        return sb;
    }
}

/*
c:\Users\Андрей\Desktop\файл.txt

Киев Нью-Йорк Амстердам Вена Мельбурн
Киев Вена Амстердам Мельбурн Нью-Йорк
* */