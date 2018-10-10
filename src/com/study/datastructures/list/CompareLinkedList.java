package com.study.datastructures.list;

/**
 * Created by dsk2 on 10/10/2018.
 */
public class CompareLinkedList {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("John");
        linkedList.add("Andy");
        linkedList.add("Ann");
        linkedList.add("Wern");

        Comparator<String> comparator = new Comparator<String> (){
            @Override
            public int compare(String value1, String value2) {
                return value1.compareToIgnoreCase(value2);
            }
        };

        Comparator<String> comparator2 = (value1, value2) -> value1.compareToIgnoreCase(value2);

        System.out.println(linkedList.max(comparator));
    }
}
