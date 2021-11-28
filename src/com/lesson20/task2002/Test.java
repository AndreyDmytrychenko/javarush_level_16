package com.lesson20.task2002;

public class Test {
    Name name;
    public static void main(String[] args) {

        System.out.println(Name.BEN.getName());
    }
    public static enum Name{
        PASHA("Pasha"),
        BEN("Ben");
        String name;
        Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
