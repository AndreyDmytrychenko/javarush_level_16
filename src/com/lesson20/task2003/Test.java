package com.lesson20.task2003;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        Map<String,String> map = new HashMap<>();
//        Properties prop = new Properties();
//        prop.setProperty("max", "not");
//        OutputStream out = new FileOutputStream("myFileOps.test");
//        prop.store(out, "my properties");
//        FileInputStream fis = new FileInputStream("myFileOps.test");
//        prop.load(fis);
//        prop.forEach((k,v) -> map.put((String)k,(String)v));
//        System.out.println(map);
        File file = File.createTempFile("myNewFile","txt" ,new File("c:\\Users\\Андрей\\Desktop\\java\\"));
        file.deleteOnExit();

    }
}
