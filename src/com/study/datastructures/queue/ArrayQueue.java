package com.study.datastructures.queue;

// FIFO
public class ArrayQueue {
    int size;
    Object[] data;
    private int initSize = 5;

    public ArrayQueue() {
        data = new Object[initSize];
    }

    public void enqueue(Object value) {
//        System.out.println("size - " + size + ", data.length - " + data.length);
        if (size == data.length) {
            Object[] newData = new Object[(int)(size * 1.5)];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
//            System.out.println("data.length - " + data.length);
        }
        data[size] = value;
        size++;
    }

    public Object dequeue() {
        Object result = data[0];
        System.arraycopy(data, 1, data, 0, size);
        size--;
        return result;
    }

    public Object peek() {
        return data[0];
    }

    public int size() {
        return size;
    }

    // [A, B, C]
    public String toString() {
        String result = "[";
        for (int i =0; i < size; i++) {
            if (i != 0) {
                result += ",";
            }
            result = result + data[i];
        }
        result += "]";
        return result;
    }
}