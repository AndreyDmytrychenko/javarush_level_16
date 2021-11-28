package com.lesson26.task2603;

import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

        public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

            @Override
            public int compare(T x, T y) {
                int res = 0;
                for (Comparator<T> com : comparators) {
                   res = com.compare(x, y);
                   if (res != 0) break;
                }
                return res;
            }
        }
}
