package com.lesson28.task2811;

import java.util.LinkedHashMap;

/*
ReentrantReadWriteLock
*/

public class Solution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
    }
}

