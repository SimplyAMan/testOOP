package ua.study.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements List, Iterable {

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private int index = size;
        @Override
        public boolean hasNext() {
            return size != 0;
        }

        @Override
        public Object next() {
            size--;
            // TODO: 10/9/2018
            return null;
        }
    }

    private static class Node {
        Object value;
        Node next;
        Node previous;

        private Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;



    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if(size == 0) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            // between two existed elements
            Node newNode = new Node(value);
            // add element at the end of list
            if (index == size) {
                newNode.previous = getNodeByIndex(index - 1);
                tail = newNode;
            } else {
                Node switchedNode = getNodeByIndex(index);
                newNode.previous = switchedNode.previous;
                newNode.next = switchedNode;
                switchedNode.previous = newNode;
            }
            if (index != 0) {
                newNode.previous.next = newNode;
            } else {
                head = newNode;
            }

/*
            Node newNode = new Node(value);
            if (index == 0 && size == 0) {
                head = tail = newNode;
            } else {
                if (index == 0) {
                    newNode.next = head;
                    head.previous = newNode;
                    head = newNode;
                } else if (index == size) {
                    Node nextNode = getNodeByIndex(index - 1);
                    newNode.previous = nextNode;
                    nextNode.next = newNode;
                } else {
                    Node nextNode = getNodeByIndex(index);
                    newNode.next = nextNode;
                    newNode.previous = nextNode.previous;
                    nextNode.previous = newNode;

                }
            }*/

            size++;
        }
    }

    @Override
    public Object remove(int index) {
        Node deletedNode = getNodeByIndex(index);
        Node tempNode = deletedNode;
        if (index == 0) {
            head = deletedNode.next;
        } else if(index == size - 1) {
            tail = deletedNode.previous;
        } else {
                deletedNode.next.previous = deletedNode.previous;
                deletedNode.previous.next = deletedNode.next;
//            deletedNode.next.previous = tempNode.previous;
            }
        /*if (index > 0) {
            deletedNode.previous.next = tempNode.next;
        } else {
            head = deletedNode.next;
        }*/
        size--;
        //getNodeByIndex(size-1).next = null;
        return deletedNode.value;
    }

    private Node getNodeByIndex(int index) {
        if(index>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node currentNode = head;
        for (int i = 1; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    @Override
    public Object get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeByIndex(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node prevNode = getNodeByIndex(index);
        Object result = prevNode.value;
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
        return false;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        Node currentNode = head;
        for(int i = 0; i < size; i++) {
            if(currentNode.value == value) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        int index = -1;
        Node currentNode = head;
        for(int i = 0; i < size; i++) {
            if(currentNode.value == value) {
                index = i;
            }
            currentNode = currentNode.next;
        }
        return index;
    }
}