package com.lesson26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Integer[] arr = {13,8,15,5,17,24,12,150,200};

        System.out.print(Arrays.toString(sort(arr)));


    }

    public static Integer[] sort(Integer[] array) {
        int median = (int) med(array);

        Arrays.sort(array, (x,y) -> Math.abs(x - median) - Math.abs(y - median));

        return array;
    }

    public static double med(Integer[] numArray) {

        Arrays.sort(numArray);
        double median;

        if (numArray.length % 2 == 0)
            median = (double) (numArray[numArray.length/2] + numArray[numArray.length/2 - 1])/2;
        else
            median = (double) numArray[(numArray.length - 1)/2];
        return median;
    }
}
