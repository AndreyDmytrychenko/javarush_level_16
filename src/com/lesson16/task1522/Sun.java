package com.lesson16.task1522;

public class Sun implements Planet {

        private static Sun instance;

        public static Sun getInstance() {
            return instance = getSun.instance;
        }

        private Sun () {

        }
        private static class getSun{
            private static final Sun instance = new Sun();
        }
    }



