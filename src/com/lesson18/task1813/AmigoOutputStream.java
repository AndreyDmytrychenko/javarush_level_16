package com.lesson18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/*
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    FileOutputStream stream;

    public static String fileName = "C:/tmp/result.txt";

    public static String getFileName() {
        return fileName;
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    public AmigoOutputStream(FileOutputStream stream) throws FileNotFoundException {
        super(AmigoOutputStream.getFileName());
        this.stream = stream;
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush @ All rights reserved.".getBytes());
        stream.close();
    }

    @Override
    public FileChannel getChannel() {
        return stream.getChannel();
    }



    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
