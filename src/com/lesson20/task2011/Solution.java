package com.lesson20.task2011;

/*
Externalizable для апартаментов
*/

import java.io.*;

public class Solution {
    Apartment apartment = new Apartment();
    public static class Apartment implements Externalizable {

        private String address = "PornHab";
        private int year = 15;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         address = (String) in.readObject();
         year = in.readInt();
        }



    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Apartment apartment = new Apartment();
        File myFile = File.createTempFile("myFile", null);
        FileOutputStream fos = new FileOutputStream(myFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(apartment);

        oos.flush();
        fos.close();
        FileInputStream fis = new FileInputStream(myFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Apartment apartment1 = (Apartment) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(apartment1);
        System.out.println(apartment);
    }
}

