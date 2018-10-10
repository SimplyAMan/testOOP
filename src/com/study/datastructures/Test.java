package com.study.datastructures;


public class Test {

    // UI
    public static void main(String[] args) {
        System.out.println("start");
        try {
            doEquals(null, "Hello");
        } catch (IllegalArgumentException e) {
            // show on UI
            System.out.println("IAE");
        } catch (Exception e) {
            // show on UI
            System.out.println("exception");
        }
        System.out.println("finish");

    }

    // business logic
    static void doEquals(Object first, Object second) {
        equals(first, second);
    }

    // db
    static void equals(Object first, Object second) {
        if (first == null) {
            throw new IllegalArgumentException();
        }
        System.out.println(first.equals(second));
    }
}