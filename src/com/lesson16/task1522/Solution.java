package com.lesson16.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String namePlanet = reader.readLine();
            if (Planet.SUN.equals(namePlanet)) {
                thePlanet = Sun.getInstance();
            } else if (Planet.MOON.equals(namePlanet)) {
                thePlanet = Moon.getInstance();
            } else if (Planet.EARTH.equals(namePlanet)) {
                thePlanet = Earth.getInstance();

            } else {
                thePlanet = null;
            }

        } catch (IOException e) {}

    }
}
