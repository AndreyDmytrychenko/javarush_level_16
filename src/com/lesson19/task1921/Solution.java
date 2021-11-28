package com.lesson19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
        public static final List<Person> PEOPLE = new ArrayList<Person>();
        public static void main(String[] args) throws IOException, ParseException {
       args = new String[]{"c:\\Users\\Андрей\\Desktop\\файл.txt"};


        BufferedWriter wr = new BufferedWriter(new FileWriter(args[0]));
            String s = "Lionel Maici 16 9 1959";
            wr.write(s);
            wr.close();


        BufferedReader re = new BufferedReader(new FileReader(args[0]));
        while (re.ready()) {
            Matcher m;
            m = Pattern.compile("(.*[а-яА-Яa-zA-Z-].*) (\\d.*) (\\d.*) (\\d.*)").matcher(re.readLine());
            SimpleDateFormat adf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            while (m.find()) {
                String name = m.group(1);
                Date date = adf.parse(m.group(2) + " " + m.group(3) + " " + m.group(4));
                PEOPLE.add(new Person(name, date));
            }
        }
        re.close();
        PEOPLE.forEach(System.out::println);
       // for (Person p : PEOPLE) System.out.println(p);
    }
}
