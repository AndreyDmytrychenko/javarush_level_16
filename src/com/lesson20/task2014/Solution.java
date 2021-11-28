package com.lesson20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //System.out.println(new Solution(4));
        File myFile = File.createTempFile("myFile", null);
        FileOutputStream fos = new FileOutputStream(myFile);
        FileInputStream fis = new FileInputStream(myFile);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Solution sol1 = new Solution(5);
        oos.writeObject(sol1);
        oos.close();
        fos.flush();

        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution sol2 =(Solution) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(sol1.string.equals(sol2.string));
        System.out.println(sol1);
        System.out.println(sol2);

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

