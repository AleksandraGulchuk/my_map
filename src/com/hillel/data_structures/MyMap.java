package com.hillel.data_structures;

import java.util.Objects;


public class MyMap<K, V> {
    private final MySet<Pair<K, V>> pairSet = new MySet<>();

    public MySet<Pair<K, V>> getPairSet() {
        return pairSet;
    }

    public MySet<K> getKeySet() {
        MySet<K> keySet = new MySet<>();
        for(Pair<K,V> pair : pairSet){
            keySet.add(pair.key);
        }
        return keySet;
    }

    public void put(K key, V value) {
        pairSet.add(new Pair<>(key, value));
    }

    public boolean containsKey(K key) {
        return pairSet.contains(new Pair<>(key, null));
    }

    public boolean containsValue(V value) {
        for (Pair<K, V> pair : pairSet) {
            if (value.equals(pair.value)) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        Pair<K, V> pair = new Pair<>(key, null);
        for (Pair<K, V> elem : pairSet) {
            if (elem.key.equals(pair.key)) {
                return elem.value;
            }
        }
        return null;
    }

    public V remove (K key){
        V deletedValue = get(key);
        pairSet.remove(new Pair<>(key, null));
        return deletedValue;
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key.equals(pair.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
