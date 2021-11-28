package com.lesson18.task1828Price;

/*
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

//      VALIDATOR AREA
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

//      TEST AREA
//        args = new String[]{"-c", "Linen Shirt", "99.80", "15"};
//        args = new String[]{"-d", "198479"};
//        args = new String[]{"-r", "19847983"};
//        args = new String[]{"-u", "19847", "Bagel", "9.99", "1"};
//        String fileName = "res/002/base.txt";

        if (args.length != 0) {
            switch (args[0]) {
                case "-c": {
                    createEntry(args[1], args[2], args[3], fileName);
                    break;
                }
                case "-r": {
                    readEntry(args[1], fileName);
                    break;
                }
                case "-u": {
                    updateEntry(args[1], args[2], args[3], args[4], fileName);
                    break;
                }
                case "-d": {
                    deleteEntry(args[1], fileName);
                    break;
                }
                default: {
                    break;
                }

            }
        }
    }

    private static void createEntry(String productName,
                                    String price,
                                    String quantity,
                                    String fileName) throws IOException {
        ArrayList<Product> products = loadProducts(fileName);
        products.add(new Product(Product.getNextId(products), productName, price, quantity));
        saveProducts(fileName, products);
    }

    private static void readEntry(String id,
                                  String fileName) throws IOException {
        ArrayList<Product> products = loadProducts(fileName);
        for (Product p : products) {
            if (Product.applyLength(p.id, 8).equals(id)) {
                System.out.println(String.format("#%s | %s | $%s | Left: %s ",
                        p.id, p.productName, p.price, p.quantity));
            }
        }

    }

    private static void updateEntry(String id,
                                    String productName,
                                    String price,
                                    String quantity,
                                    String fileName) throws IOException {
        ArrayList<Product> products = loadProducts(fileName);
        for (Product p : products) {
            if ((p.id).equals(Product.applyLength(id, 8))) {
                p.productName = Product.applyLength(productName, 30);
                p.price = Product.applyLength(price, 8);
                p.quantity = Product.applyLength(quantity, 4);
            }
        }
        saveProducts(fileName, products);
    }

    private static void deleteEntry(String id,
                                    String fileName) throws IOException {
        ArrayList<Product> products = loadProducts(fileName);
        for (Product p : products) {
            if ((p.id).equals(Product.applyLength(id, 8))) {
                products.remove(p);
            }
        }
        saveProducts(fileName, products);
    }

    private static void saveProducts(String fileName, ArrayList<Product> products) throws IOException { // writes file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < products.size(); i++) {
            writer.write(products.get(i).id);
            writer.write(products.get(i).productName);
            writer.write(products.get(i).price);
            writer.write(products.get(i).quantity);
            if (i != products.size() - 1) writer.write("\n");
        }
        writer.close();
    }

    private static ArrayList<Product> loadProducts(String fileName) throws IOException { // loads products from file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.length() < 46) break;
            products.add(new Product(
                    line.substring(0, 8),
                    line.substring(8, 38),
                    line.substring(38, 46),
                    line.substring(46)));
        }
        reader.close();
        return products;
    }

    public static class Product {
        private String id;
        private String productName;
        private String price;
        private String quantity;

        Product(String id, String productName, String price, String quantity) {
            this.id = applyLength(id, 8);
            this.productName = applyLength(productName, 30);
            this.price = applyLength(price, 8);
            this.quantity = applyLength(quantity, 4);
        }

        static String getNextId(List<Product> products) { // finds max ID and returns next
            int maxId = 0;
            for (Product p : products) {
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(p.id);
                if (matcher.find()) {
                    int id = Integer.parseInt(matcher.group(1));
                    maxId = Math.max(id, maxId);
                }
            }
            return String.valueOf(++maxId);
        }

        static String applyLength(String original, int length) {    // applies target length to any string
            if (original.length() <= length) {
                StringBuffer sb = new StringBuffer(60);
                return new String(sb.append(original).append(" ".repeat(Math.max(0, length - original.length()))));
            } else {
                return original.substring(0, 30);
            }
        }
    }
}