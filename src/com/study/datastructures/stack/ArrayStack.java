package com.study.datastructures.stack;// LIFO

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private Object[] array;
    private int size;

    public ArrayStack() {
        this(5);
    }

    public ArrayStack(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void push(E value) {
        if (size == array.length) {
            Object[] newArray = new Object[(size / 2 * 3) + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);

            array = newArray;
        }

        array[size] = value;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        @SuppressWarnings("unchecked")
        E result = (E) array[size - 1];
        array[size - 1] = null;
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException("stack is empty");
        }

        return (E) array[size - 1];
    }


}