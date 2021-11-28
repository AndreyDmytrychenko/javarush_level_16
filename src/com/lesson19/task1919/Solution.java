package com.lesson19.task1919;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[] {"c:\\Users\\Андрей\\Desktop\\файл.txt"};
//        BufferedWriter wr = new BufferedWriter(new FileWriter(args[0]));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String string = "";
//        while (!(string = reader.readLine()).isEmpty()) {
//            wr.write(string);
//        }
//        wr.close();
//        reader.close();

        BufferedReader re = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        TreeSet<String> set = new TreeSet<>();
        while (re.ready()) {
            String[] arr = re.readLine().split(" ");
            if (map.containsKey(arr[0])){
                map.put(arr[0], map.get(arr[0]) + Double.parseDouble(arr[1]));
            } else {
                map.put(arr[0], Double.parseDouble(arr[1]));
            }
        }
        re.close();
        Double max = map.get(map.lastKey());
        map.forEach((k, v) -> {
            if (max.equals(v)) set.add(k);
        });
        set.forEach(System.out::println);

    }
}

/*
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1
*/
