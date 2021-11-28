package com.lesson19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String file1 = re.readLine();
        String file2 = re.readLine();
        re.close();
        ArrayList<String> listFile1 = new ArrayList<>();
        ArrayList<String> listFile2 = new ArrayList<>();


        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        String str1 = "";
        while ((str1 = reader1.readLine()) != null) listFile1.add(str1);
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        String str2 = "";
        while ((str2 = reader2.readLine()) != null) listFile2.add(str2);
        reader2.close();

        while (listFile1.size() > 0 && listFile2.size() > 0) {

            if (listFile1.get(0).equals(listFile2.get(0))) {
                lines.add(new LineItem(Type.SAME, listFile1.get(0)));
                listFile1.remove(0);
                listFile2.remove(0);

            } else if (listFile1.get(1).equals(listFile2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, listFile1.get(0)));
                listFile1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, listFile2.get(0)));
                listFile2.remove(0);
            }
        }
        if (listFile1.size() > 0) {
            for (String s : listFile1) {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }
        if (listFile2.size() > 0) {
            for (String s : listFile2) {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }



        for (LineItem t : lines) System.out.println(t.type +" "+t.line);
        System.out.println();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

/*
c:\Users\Андрей\Desktop\новый файл.txt
c:\Users\Андрей\Desktop\файл.txt
*/