package com.lesson19.task1907;

public class Test {
    public static void main(String[] args) {
        String str = "Вщт и проworldходит мой отпуск,world без всякого см!ысла, скоро ко?нец. На рабо;:ту не хочется";

        System.out.println(str.replaceAll("[^\\w]"," "));
    }
}
