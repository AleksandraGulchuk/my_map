package com.hillel.data_structures;

import java.util.Iterator;


public class MySet<T> implements Iterable<T> {
    private final Node[] buckets;
    private int size = 0;

    public MySet(int length) {
        this.buckets = new Node[length];
    }

    public MySet() {
        this(16);
    }

    public int size() {
        return size;
    }

    public void add(T elem) {
        int bucketIndex = getBucketIndex(elem);
        Node existNode = findNode(elem, bucketIndex);
        if (existNode != null) {
            existNode.value = elem;
        } else {
            Node newNode = new Node(elem);
            newNode.next = buckets[bucketIndex];
            buckets[bucketIndex] = newNode;
            ++size;
        }
    }

    public boolean contains(T elem) {
        Node existNode = findNode(elem, getBucketIndex(elem));
        return existNode != null;
    }

    public T get(int index) {
        int i = 0;
        for (T elem : this) {
            if (i == index) return elem;
            i++;
        }
        return null;
    }

    public boolean remove(T elem) {
        if (size == 0) {
            return false;
        }
        int bucketIndex = getBucketIndex(elem);
        Node existNode = findNode(elem, bucketIndex);
        if (existNode == null) {
            return false;
        } else {
            Node cur = buckets[bucketIndex];
            Node prev = null;
            for (; !cur.equals(existNode); cur = cur.next) {
                prev = cur;
            }
            if (prev == null) {
                buckets[bucketIndex] = cur.next;
            } else prev.next = cur.next;
        }
        --size;
        return true;
    }


    private int getBucketIndex(T elem) {
        int hash = elem.hashCode();
        hash = hash > 0 ? hash : -hash;
        return hash % buckets.length;
    }

    private Node findNode(T elem, int bucketIndex) {
        for (Node current = buckets[bucketIndex]; current != null; current = current.next) {
            if (current.value.equals(elem))
                return current;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curBucketIndex = -1;
            private Node cur = null;

            @Override
            public boolean hasNext() {
                if (cur != null && cur.next != null) {
                    cur = cur.next;
                    return true;
                }
                for (++curBucketIndex; curBucketIndex < buckets.length; ++curBucketIndex) {
                    if (buckets[curBucketIndex] != null) {
                        cur = buckets[curBucketIndex];
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return (T) cur.value;
            }
        };
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
