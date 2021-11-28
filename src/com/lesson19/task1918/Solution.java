package com.lesson19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {

        args = new String[] {"link"};
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String fileName = re.readLine();
        re.close();
        StringBuilder sb = new StringBuilder();
        String line = "";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

            Document document = Jsoup.parse(sb.toString(),"", Parser.xmlParser());
            Elements elem = document.select(args[0]);

//                Matcher m = Pattern.compile("<\\/?.>").matcher(elem.toString());
//                m.find();
//                String str = elem.toString().replaceAll("<\\/?.>", m.group()+"\n");
        System.out.println(elem);
    }
}
/*
c:\Users\Андрей\Desktop\новый файл.txt
c:\Users\Андрей\Desktop\файл.txt
*/
// <span>.+?<\/.+?>
// <.?span.*?>(.*<.*>)?