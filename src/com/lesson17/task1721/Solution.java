package com.lesson17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String fileName1;
    public static String fileName2;
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {}

            try (BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)))){
                String str = "";
                while ((str = fileReader1.readLine()) != null) {
                    allLines.add(str);
                }
            } catch (IOException e) {}

        try (BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)))){
            String str = "";
            while ((str = fileReader2.readLine()) != null) {
                forRemoveLines.add(str);
            }
        } catch (IOException e) {}

                new Solution().joinData();
        }




    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (int i = 0; i < allLines.size(); i++) {
                for (int t = 0; t < forRemoveLines.size(); t++) {
                    if (allLines.get(i).contains(forRemoveLines.get(t))) allLines.remove(i);
                }
            }
        } else {
                    allLines.removeAll(allLines);
                    throw new CorruptedDataException();
            }
    }
}
