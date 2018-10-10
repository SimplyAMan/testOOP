package com.study.datastructures.map;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dsk2 on 10/10/2018.
 */
public class HashMapTest {
    HashMap<String, Integer> testMap = new HashMap<>();

    @Test
    public void testSizeOfEmpty() {
        assertEquals(0,testMap.size());
    }

    @Test
    public void testPutAndGet() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Annaaaaaaaaaaaaarrrrrrrrrrrr",12);
        testMap.put("Annaaaaaaaaaaaaarrrrrrrrrrr",12);
        testMap.put("Annaaaaaaaaaaaaarrrrrrrrrr1",12);

        assertEquals(4, testMap.size());
        assertEquals(new Integer(22), testMap.get("Andy"));
    }

    @Test
    public void testPutHundredValues() {
        for (int i = 0; i < 100; i++) {
            testMap.put(Integer.toString(i), i);
        }

        assertEquals(100, testMap.size());
    }

    @Test
    public void testPutNull() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Anna",null);

        assertEquals(2, testMap.size());
        assertEquals(null, testMap.get("Anna"));
    }

    @Test
    public void testUpdateValue() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Anna",22);
        testMap.put("Anna",12);

        assertEquals(2, testMap.size());
        assertEquals(new Integer(12), testMap.get("Anna"));
    }
    @Test
    public void testPutIfAbsent() throws Exception {
        testMap.putIfAbsent("Anna",12);

        assertEquals(1, testMap.size());
        assertEquals(new Integer(12), testMap.get("Anna"));
    }

    @Test
    public void testPutIfAbsentIfExists() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Anna",22);
        testMap.putIfAbsent("Anna",12);

        assertEquals(2, testMap.size());
        assertEquals(new Integer(22), testMap.get("Anna"));
    }

    @Test
    public void containsKey() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Anna",12);

        assertEquals(true, testMap.containsKey("Anna"));
    }
    @Test
    public void testNotContainsKey() throws Exception {
        testMap.put("Andy",22);
        testMap.put("Anna",12);

        assertEquals(false, testMap.containsKey("AnnA"));
    }

    @Test
    public void containsKeyInEmpty() throws Exception {
        assertEquals(false, testMap.containsKey("Anna"));
    }

    @Test
    public void containsKeyWithNull() throws Exception {
        testMap.put("Andy",null);
        assertEquals(true, testMap.containsKey("Andy"));
    }
}