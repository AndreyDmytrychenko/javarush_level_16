package com.lesson25.task2502;

import java.util.ArrayList;
import java.util.List;

/*
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new ArrayList<Wheel>();

            String [] tmp = loadWheelNamesFromDB();

            if (tmp.length != 4) throw new IllegalArgumentException();
            else
                for (int i = 0; i < tmp.length; i++) {
                    wheels.add(Wheel.valueOf(tmp[i]));
                }

            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

        for (Wheel wheel : new Car().wheels) System.out.println(wheel);
    }
}

