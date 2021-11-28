package com.lesson27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Избавляемся от меток
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {

        for (int i = 0; i <= string.length() - substring.length(); i++) {

            for (int j = i; string.charAt(j) == substring.charAt(j - i); j++) {

                if (j == i + substring.length() - 1) {
                    return true;
                }
            }
        }
                return false;
    }
}




/*static boolean isSubstringPresent(String substring, String string) {

        if ((string.length() - substring.length()) < 0) return false;

       char[] str = string.toCharArray();
       char[] sub = substring.toCharArray();
       int length = sub.length - 1;

       for (int i = 0; i < str.length; i++) {
           int t = 0;
           if (str[i] == sub[t]) {
               while (length-- >= 0){
                   if(str[i++] == sub[t++]) {

                   } else return false;
               }
               return true;
           }
       }
        return false;
    }
}*/