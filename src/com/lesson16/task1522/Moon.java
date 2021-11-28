package com.lesson16.task1522;

public class Moon implements Planet {

        private static Moon instance;

        public static Moon getInstance() {
            return instance = getMoon.instance;
        }

        private Moon() {
        }
        private static class getMoon{
            private static final Moon instance = new Moon();
        }



    }


