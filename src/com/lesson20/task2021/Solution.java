package com.lesson20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("fuck");
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException("no");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            SubSolution sub1 = new SubSolution();
            FileOutputStream  fos = new FileOutputStream("myFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(sub1);
            } catch (NotSerializableException e) {
                System.out.println(e.getMessage());
            }

            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("myFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                SubSolution sub = (SubSolution) ois.readObject();
            } catch (NotSerializableException e) {
                System.out.println(e.getMessage());
            }
            ois.close();
            fis.close();
    }
}
