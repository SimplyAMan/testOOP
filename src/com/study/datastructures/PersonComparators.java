package com.study.datastructures;

import com.study.datastructures.stack.Comparator;

/**
 * Created by dsk1 on 10/10/2018.
 */
public class PersonComparators {

    // screaming snake
    public static final Comparator NAME_COMPARATOR = new Comparator() {
        @Override
        public int compare(Object first, Object second) {
            Person firstPerson = (Person) first;
            Person secondPerson = (Person) second;
            return firstPerson.name.compareTo(secondPerson.name);
        }
    };


    public static final Comparator AGE_COMPARATOR = new Comparator() {
        @Override
        public int compare(Object first, Object second) {
            Person firstPerson = (Person) first;
            Person secondPerson = (Person) second;
            return firstPerson.age - secondPerson.age;
        }
    };
}

