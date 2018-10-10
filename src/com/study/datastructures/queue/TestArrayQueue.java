package com.study.datastructures.queue;

/**
 * Created by dsk2 on 10/8/2018.
 */
public class TestArrayQueue {
    public static void main(String [] argv) {
        ArrayQueue arrayQueue = new ArrayQueue();

        System.out.println("------------------------------------");
        arrayQueue.enqueue('A');
        arrayQueue.enqueue('B');
        System.out.println(arrayQueue.size()); //2
        System.out.println(arrayQueue.peek()); //'A'
        System.out.println(arrayQueue); // ['A', 'B']

        System.out.println("------------------------------------");
        arrayQueue.dequeue();
        System.out.println(arrayQueue.size()); //1
        System.out.println(arrayQueue.peek()); //'B'
        System.out.println(arrayQueue); // ['B']
//        enqueue
        System.out.println("------------------------------------");
        arrayQueue.dequeue();
        System.out.println(arrayQueue.size()); //0
        System.out.println(arrayQueue.peek()); //null
        System.out.println(arrayQueue); // []
/*
        System.out.println("------------------------------------");
        arrayQueue.dequeue();
        System.out.println(arrayQueue.size()); //0
        System.out.println(arrayQueue.peek()); //null
        System.out.println(arrayQueue); // []
*/
        System.out.println("------------------------------------");
        for(int i = 1; i <= 10; i++){
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue.size()); //10
        System.out.println(arrayQueue); // [1,2,...,10]
    }
}
