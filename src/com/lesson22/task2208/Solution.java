package com.lesson22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "12");
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder where = new StringBuilder();

        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value == null) continue;
            if (where.toString().length() > 0) where.append(" and ");
            where.append(key + " = '" + value + "'");

        }

        return where.toString();
    }
}
