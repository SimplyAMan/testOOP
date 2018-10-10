package com.study.datastructures.stack;


public interface Comparator {

    // f > s return x > 0
    // f < s return x < 0
    // f == s return x = 0
    int compare(Object first, Object second);
}