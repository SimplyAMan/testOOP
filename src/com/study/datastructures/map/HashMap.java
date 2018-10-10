package com.study.datastructures.map;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {
    private List<Entry<K, V>>[] buckets;
    private int size;

    private int countOfBuckets = 5;

    private static final double LOAD_FACTOR = 0.5;

    private List<Entry<K, V>>[] getBuckets (int countOfBuckets) {
        buckets = (List<Entry<K, V>>[]) new List[countOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        return buckets;
    }

    public HashMap() {
        buckets = getBuckets(countOfBuckets);
    }

    private List<Entry<K, V>>[] extendList(List<Entry<K, V>>[] buckets) {
        // extend List
        List<Entry<K,V>>[] newBuckets = getBuckets(size);
        // copy List
        for (List<Entry<K,V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                int index = getIndex(entry.key, newBuckets);
                List<Entry<K, V>> newBucket = newBuckets[index];
                newBucket.add(new Entry<K, V>(entry.key, entry.value));
            }
        }
        return newBuckets;
    }

    @Override
    public V put(K key, V value) {
        int expectedLengthOfBuckets = (int) Math.round(buckets.length * LOAD_FACTOR);
        System.out.println("expectedLengthOfBuckets - " + expectedLengthOfBuckets + ", size - " + size);
        if(size > expectedLengthOfBuckets) {
            buckets = extendList(buckets);
        }
        System.out.println("buckets.length - " + buckets.length);
        int index = getIndex(key, buckets);
        List<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        bucket.add(new Entry<K, V>(key, value));
        size++;
        return null;
    }

    private int getIndex(K key, List<Entry<K, V>>[] originalBuckets) {
        return Math.abs(key.hashCode() % originalBuckets.length);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        V currentValue = get(key);
        if (currentValue == null) {
            buckets[getIndex(key, buckets)].add(new Entry<K, V>(key, value));
            size++;
        }
        return currentValue;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key, buckets);
        List<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key, buckets);
        List<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}