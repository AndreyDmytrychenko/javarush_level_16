package com.lesson19.task1921;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "Иванов Петр Васильевич 16 21 1985";
        Matcher m = Pattern.compile("(.+[а-яА-Я]. +)(\\d.*) (\\d.*) (\\d.*)").matcher(s);
        while (m.find()) {
            System.out.println(m.group(1).trim() +" "+Integer.parseInt(m.group(2))+" "+Integer.parseInt(m.group(3))
                    +" "+Integer.parseInt(m.group(4)));
        }
    }
}
