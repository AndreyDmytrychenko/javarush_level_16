package com.lesson20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;
    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("c:\\Users\\Андрей\\Desktop\\файл.txt");
        sol.writeObject("test1");
        sol.close();

        File file = File.createTempFile("someFile", null);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution sol1 = (Solution) ois.readObject();
        ois.close();
        fis.close();

        sol1.writeObject("test2");
        sol1.close();

        BufferedReader re = new BufferedReader(new FileReader(sol1.fileName));
        while (re.ready()){
            System.out.println(re.readLine());
        }
        re.close();
    }
}

