package com.raed.dsa.map;


/**
 * Created by Raed Saeed on 25/11/2024
 */
public interface Map<K, V> {
    int size();

    boolean isEmpty();

    boolean contains(K key);

    V get(K key);

    boolean put(K k, V v);

    boolean remove(K k);

    Iterable<K> keys();

    Iterable<V> values();

    Iterable<Entry<K, V>> entrySet();


    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
