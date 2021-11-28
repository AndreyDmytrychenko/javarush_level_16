package com.lesson22.task2210;

/*
StringTokenizer
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String[] str = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(str));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        String[] t = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
           t[i] = list.get(i);
        }
        return t;
    }
}
