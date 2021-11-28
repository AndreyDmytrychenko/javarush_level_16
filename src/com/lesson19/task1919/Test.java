package com.lesson19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
  //      args = new String[] {"c:\\Users\\Андрей\\Desktop\\файл.txt"};
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
        ArrayList<String> list = new ArrayList<>();
        while (re.ready()) {
          list.add(re.readLine());
        }

        re.close();
        for (String s : list) {
            String[] arr = s.split(" ");
            map.merge(arr[0], Double.parseDouble(arr[1]), Double::sum);
        }
        Double max = Collections.max(map.values());
        TreeSet<String> set = new TreeSet<>();
        for (Map.Entry<String,Double> pair : map.entrySet()) {
            if (max.equals(pair.getValue())) set.add(pair.getKey());
        }
        for (String s : set) System.out.println(s);

    }
}
/*
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1
*/
