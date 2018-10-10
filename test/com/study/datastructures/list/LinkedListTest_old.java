package com.study.datastructures.list;

import com.study.datastructures.list.LinkedList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by dsk2 on 10/9/2018.
 */
public class LinkedListTest_old {
    LinkedList linkedList = new LinkedList();

    @Test
    public void testAdd() throws Exception {
        linkedList.add("A");
        int size = linkedList.size();
        assertEquals(1,size);
        assertEquals("A",linkedList.get(size));
    }

    @Test
    public void testAddTwo() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        int size = linkedList.size();
        assertEquals(2,size);
        assertEquals("B",linkedList.get(size));
    }

    @Test
    public void testAddTwoAndNull() throws Exception {
        linkedList.add("A");
        linkedList.add(null);
        linkedList.add("B");

        assertEquals(3,linkedList.size());
        assertEquals("B",linkedList.get(3));
    }

    @Test
    public void testAddByIndex() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C",2);

        assertEquals(3, linkedList.size());
        assertEquals("C",linkedList.get(2));
    }
    @Test(expected = NoSuchElementException.class)
    public void testAddByIndexBiggerThenSize() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C",3);
    }

    @Test
    public void testRemove() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.remove(1);

        assertEquals(1,linkedList.size());
        assertEquals("B",linkedList.get(1));
    }
/*
    @Test
    public void get() throws Exception {

    }
*/
    @Test
    public void set() throws Exception {

    }

    @Test
    public void clear() throws Exception {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.clear();

        assertEquals(0,linkedList.size());
    }

/*
    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void indexOf() throws Exception {

    }

    @Test
    public void lastIndexOf() throws Exception {

    }
*/
}