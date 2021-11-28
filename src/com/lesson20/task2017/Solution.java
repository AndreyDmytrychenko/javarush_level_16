package com.lesson20.task2017;

import java.io.*;

/*
Десериализация
*/

public class Solution {


    public A getOriginalObject(ObjectInputStream objectStream) {

        try {
          return (A) objectStream.readObject();

            } catch(Exception e){
                return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {
    Solution solution = new Solution();
    B b = solution.new B();

    }
}

