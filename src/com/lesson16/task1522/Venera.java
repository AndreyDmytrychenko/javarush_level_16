package com.lesson16.task1522;

public class Venera implements Planet {
    private Venera(){}
    private static Venera instance;
    public static synchronized Venera getVenera() {

                if (instance == null) {
                    instance = new Venera();

        }
        return instance;
    }
}
