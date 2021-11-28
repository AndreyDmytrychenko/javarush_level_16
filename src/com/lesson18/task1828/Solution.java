package com.lesson18.task1828;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    private static String fileName;

    public static void main(String[] args) throws IOException {
              // args = new String[]{"-d", "19847"};

       args = new String[]{"-u", "19847", "Bagel", "9.99", "1"};
        if (args.length <= 1) return;
        fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if ("-u".equals(args[0])) updateById(getNewString(getRequestParameters(args)));
        if ("-d".equals(args[0])) deleteById(args[1]);
        BufferedReader reFi = new BufferedReader(new FileReader(fileName));
        while (reFi.ready()) System.out.println(reFi.readLine());
        reFi.close();
    }

    private static List<String> getRequestParameters(String[] args) {
        List<String> parameters = new ArrayList<>(4);
        parameters.add(args[1]);
        parameters.add(args[2].substring(0, Math.min(args[2].length(), 30)));
        parameters.add(args[3]);
        parameters.add(args[4]);
        return parameters;
    }

    private static String getNewString(List<String> stringList) {
        return String.format("%n%-8s%-30s%-8s%-4s",
                stringList.get(0),
                stringList.get(1),
                stringList.get(2),
                stringList.get(3));
    }

    private static void updateById(String string) throws IOException {
        String id = string.substring(0, 8).trim();
        List<String> fileAllString = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null)
                fileAllString.add((line.substring(0, 8).trim()).equals(id) ? line.replaceAll(line, string) : ("\n" + line));
        }

        firstLineFormat(fileAllString);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String str : fileAllString)
                fileWriter.write(str);
        }
    }

    private static void firstLineFormat(List<String> fileAllString) {
        if (fileAllString.get(0).charAt(0) == '\n')
            fileAllString.set(0, fileAllString.get(0).replace("\n", ""));
    }

    private static void deleteById(String id) throws IOException {
        List<String> fileAllString = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null)
                if (!(line.substring(0, 8).trim()).equals(id))
                    fileAllString.add(("\n" + line));
        }

        firstLineFormat(fileAllString);

        try (FileWriter writer = new FileWriter(fileName)) {
            for (String str : fileAllString)
                writer.write(str);
        }
    }
}
