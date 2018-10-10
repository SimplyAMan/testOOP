package com.study.datastructures.list;

/**
 * Created by dsk2 on 10/8/2018.
 */
public class TestArrayList {

    public static void main(String[] argv) {
        List arrayList = new ArrayList();

        arrayList.add("A");
        System.out.println(arrayList.size()); // 1
        System.out.println(arrayList.get(0)); // A
        System.out.println(arrayList); // [A]

        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.size()); // 11
        System.out.println(arrayList); // [A,0,1,2,...,19]

        System.out.println("-------------- arrayList.indexOf(0)");
        System.out.println(arrayList.indexOf(0)); // 1
        System.out.println("-------------- arrayList.indexOf(\"A\")");
        System.out.println(arrayList.indexOf("A")); // 0

        System.out.println("-------------- remove(9)");
        arrayList.remove(9);// 7
        System.out.println(arrayList); // without 7

        System.out.println("-------------- set(\"b\", 5)");
        System.out.println(arrayList.set("b", 5)); // "4"
        System.out.println(arrayList); // instead of 4 we have "b"

        arrayList.add(1.2); //
        System.out.println("-------------- afer add 1.2");
        System.out.println(arrayList); // at end we have 1.2

        arrayList.add("c",5);
        System.out.println("-------------- after add c");
        System.out.println(arrayList); // before b we have "c"
        for (int i = 0; i < 5; i++) {
            arrayList.add(i,i);
        }
        System.out.println("-------------- after add some elements");
        System.out.println(arrayList); // before b we have "c"

        System.out.println("arrayList contains \"c\"? - " + arrayList.contains("c"));
        System.out.println("arrayList contains \"y\"? - " + arrayList.contains("y"));

        System.out.println("arrayList lastIndexOf 1? - " + arrayList.lastIndexOf(1));
        System.out.println("arrayList lastIndexOf \"1\"? - " + arrayList.lastIndexOf("1"));

        arrayList.clear(); //
        System.out.println("-------------- afer clear");
        System.out.println(arrayList); // []
    }
}
