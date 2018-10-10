package com.study.datastructures.queue;

import java.util.StringJoiner;

public class LinkedQueue implements Queue {
    Node tail;
    Node head;
    int size;

    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public Object dequeue() {
        Node result = head;
        head = result.next;
        size--;
        return result.value;
    }

    @Override
    public Object peek() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            String value = String.valueOf(tempNode.value);
            stringJoiner.add(value);
            tempNode = tempNode.next;
        }
        return stringJoiner.toString();
    }
}
