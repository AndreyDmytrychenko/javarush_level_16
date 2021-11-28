package com.lesson20.task2025;


/*

Алгоритмы-прямоугольники

*/

public class Solution {

    public static void main(String[] args) {

        byte[][] a1 = new byte[][]{

                {1, 1, 0, 0},

                {1, 1, 0, 0},

                {1, 1, 0, 0},

                {1, 1, 0, 1}

        };

        byte[][] a2 = new byte[][]{

                {1, 0, 0, 1},

                {0, 0, 0, 0},

                {0, 0, 0, 0},

                {1, 0, 0, 1}

        };





        int count1 = getRectangleCount(a1);

        System.out.println("count = " + count1 + ". Должно быть 2");

        int count2 = getRectangleCount(a2);

        System.out.println("count = " + count2 + ". Должно быть 4");

    }

    public static int getRectangleCount(byte[][] a) {

        byte[][] matrix = a;

        int countRect = 0;

        for (int i = 0; i < matrix.length; i++){          //идём по строкам

            for (int j = 0; j < matrix.length; j++){         //идём по столбцам

                if (matrix[i][j] == 1 ){                                   // если в ячейке (1)

                    if (i < matrix.length-1 && j < matrix.length-1) {        // и это не последняя строчка и не последний столбец (их пока не учитываем)

                        if (matrix[i][j + 1] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j+1] == 0 ) {   // если снизу, справа и подиогонали соседи = (0)

                            countRect++;           // это я прибавляю в каунт прямоугольники, у которых правый нижний угол с трёх сторон окружён нулями

                        }
                    }
                }
            }
        }

        for (int j = 0; j<matrix.length; j++) {                           // бежим по самой нижней строке

            if (matrix[matrix.length - 1][j] == 1 && j < matrix.length - 1) {  // если в ячейке (1) и это не последняя ячейка

                if (matrix[matrix.length - 1][j + 1] == 0) {                 // смотрим есть ли в следующей (0)

                    countRect++;                                         // если есть то +прямоугольник

                }

            }

        }

        for (int i = 0; i<matrix.length; i++){                                // бежим по правому столбцу

            if (matrix[i][matrix.length-1] == 1 && i< matrix.length-1){  // если в ячейке (1) и это не последняя ячейка

                if (matrix[i+1][matrix.length-1] == 0 ){                 // смотрим есть ли в следующей (0)

                    countRect++;                                         // если есть то +прямоугольник

                }

            }

        }

        if (matrix[matrix.length-1][matrix.length-1] == 1) countRect++;    // если в правом нижнем углу (1) то +прямоугольник


        return countRect;

    }

}






