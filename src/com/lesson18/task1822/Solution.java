package com.lesson18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
       args = new String[] {"88465765"};
        if (args.length > 0 ) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
            String line;
            while (!(line = reader.readLine()).isEmpty()) wr.write(line+"\n");
            wr.close();
            reader.close();

            BufferedReader re = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = re.readLine()) != null) {
                String[] data = str.split(" ");
                    if (data[0].equals(args[0])) {
                        for (String s : data) System.out.print(s + " ");
                }
            }
                re.close();
        }
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
13234224 трусы зеленые с пушком 12.33 500
88465765 трусы красно-желтые с пушком 124.33 33440
1666253 трусы синие 10.45 33
4885566 трусы черные женски 45.93 25
*/
/*
BufferedReader re = new BufferedReader(new FileReader(fileName));
    List<String> list = new ArrayList<>();
    String str;
            while ((str = re.readLine()) != null) {
                    list.add(str);
                    }
                    re.close();
                    for (int i = 0; i < list.size(); i++) {
        String[] data = list.get(i).split(" ");
        if (data[0].equals(args[0])) {
        for (String s : data) System.out.print(s + " ");*/
