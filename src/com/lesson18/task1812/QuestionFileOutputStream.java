package com.lesson18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    AmigoOutputStream stream;

    public QuestionFileOutputStream(AmigoOutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
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
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if ("Д".equals(reader.readLine())) {
        stream.close();
        }
    }
}

