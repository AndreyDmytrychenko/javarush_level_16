package com.lesson19.task1904;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String str;
        while (!(str = reader.readLine()).isEmpty()){
            writer.write(str);
        }
        reader.close();
        writer.close();
        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new FileInputStream(fileName)));
        System.out.println(psa.read());

        psa.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {

            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            String dateStr = line.substring(line.length() - 10, line.length());
            Date birthDate = null;
            try {
                birthDate = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String fml = line.substring(0, line.length() - 11);
            String[] data = fml.split(" ");
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
/*
c:\Users\Андрей\Desktop\файл.txt
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1950
*/
