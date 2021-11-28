package com.lesson24.task2410;

/*
Рефакторинг, анонимные классы
*/

import java.util.LinkedList;
import java.util.List;

/*
Рефакторинг, анонимные классы
*/


public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;



    public Iterator getIterator(final String name) {

        Iterator iterator = new Iterator() {


            @Override
            public Iterator next() {

                countItems++;
                System.out.println(name + " item " + countItems);
                return this;
            }
        };
        return iterator.next();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}