package com.lesson18.task1827;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readFileName.readLine();
        readFileName.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String>list = new ArrayList<>();
        while (fileReader.ready()) {
            list.add(fileReader.readLine());
        }
        fileReader.close();
        if (args.length == 0) {
            return;
        } else if (args[0].equals("-c")) {
            int minId;
            List<Integer> intList = new ArrayList<>();
            for (String str : list) {
                minId = Integer.parseInt(str.substring(0, 8).trim());
                intList.add(minId);
            }
            Collections.sort(intList);
            int maxId = intList.get(intList.size()-1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            String id = String.format("%-8d", ++maxId);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.8s", args[2]);
            String quantity = String.format("%-4.4s", args[3]);
            String result = "\n"+ id + productName + price + quantity;
            writer.write(result);
            writer.close();
        }


            BufferedReader re = new BufferedReader(new FileReader(fileName));
            while (re.ready()) System.out.println(re.readLine());
            }
        }


// c:\Users\Андрей\Desktop\файл.txt
/*
if (args.length == 0) {
            return;
        } else if (args[0].equals("-c")) {
            int minId;
            List<Integer> intList = new ArrayList<>();
            for (String str : list) {
                minId = Integer.parseInt(str.substring(0, 8).trim());
                intList.add(minId);
            }
            Collections.sort(intList);
            int maxId = intList.get(intList.size()-1);
BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            String id = String.format("%-8d", maxId+1);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
            String quantity = String.format("%-4d", Integer.parseInt(args[3]));
            String result = id + productName + price + quantity;
            writer.write(result);
            writer.close();
* */