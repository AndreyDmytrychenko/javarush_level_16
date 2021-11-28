package com.lesson19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("c:/Users/Андрей/Desktop/файл.txt"));
        String line = scanner.nextLine();
        System.out.println(line);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        String dateStr = line.substring(line.length() - 10, line.length());
        Date date = sdf.parse(dateStr);
        String d = sdf.format(date);
        String s = sdf.parse(d).toString();

        String fml = line.substring(0, line.length() - 11);
        String[] data = fml.split(" ");
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        System.out.println(String.format("%s %s %s %s", lastName, firstName, middleName, s));
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1950
*/