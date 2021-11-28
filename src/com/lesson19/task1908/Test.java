package com.lesson19.task1908;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Яа-я]");
        Matcher matcher = pattern.matcher("2 3 4 5 6 4 f Oдr t");
        System.out.println(matcher.find());
    }
}
