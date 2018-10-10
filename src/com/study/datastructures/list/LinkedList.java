package com.study.datastructures.list;

import com.study.datastructures.list.List;

import java.util.Iterator;

public class LinkedList<E> implements List<E>, Iterable {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> { // remove static
        E value;
        Node<E> next;

        Node<E> previous;

        private Node(E value) {
            this.value = value;
        }

    }

    public E max(Comparator comparator) {
        Node<E> currentNode = head;
        Node<E> node = currentNode;
        for (int i = 0; i < size; i++) {
            if(comparator.compare(currentNode.value, node.value) < 0) {
                currentNode = node;
            }
            node = node.next;
        }
        return currentNode.value;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        private int count = 0;

        @Override
        public boolean hasNext() {
            return count != size;
        }

        @Override
        public E next() {
            count++;
            return get(count - 1);
        }

    }

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node(value);
        if (index == size) {
            newNode.previous = getNodeByIndex(index - 1);
            tail = newNode;
        } else {
            Node shiftedNode = getNodeByIndex(index);
            newNode.previous = shiftedNode.previous;
            newNode.next = shiftedNode;
            shiftedNode.previous = newNode;
        }
        if (index == 0) {
            head = newNode;
        } else {
            newNode.previous.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> deletedNode = getNodeByIndex(index);
        if (index == 0) {
            head = deletedNode.next;
        } else if (index == size - 1) {
            tail = deletedNode.previous;
        } else {
            deletedNode.next.previous = deletedNode.previous;
            deletedNode.previous.next = deletedNode.next;
        }
        size--;
        return deletedNode.value;
    }

    private Node<E> getNodeByIndex(int index) {
        checkIfIndexOutOfBound(index);
        Node<E> currentNode = head;
        for (int i = 1; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public E get(int index) {
        return getNodeByIndex(index).value;
    }

    private void checkIfIndexOutOfBound(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(E value, int index) {
        checkIfIndexOutOfBound(index);
        Node<E> prevNode = getNodeByIndex(index);
        E result = prevNode.value;
        prevNode.value = value;
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(E value) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == value) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = -1;
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == value) {
                index = i;
            }
            currentNode = currentNode.next;
        }
        return index;
    }

    /*public static void main(String[] args) {
        LinkedList arrayList = new LinkedList();
        arrayList.add(1);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add(1.2);
        arrayList.add(null);
        arrayList.add(-1);
        for (E var: arrayList) {
            System.out.println(var);
        }
    }*/
}