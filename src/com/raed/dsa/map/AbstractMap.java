package com.raed.dsa.map;


import java.util.Iterator;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterable<K> keys() {
        return new KeyIterable();
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }

    private class KeyIterator implements Iterator<K> {
        Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }
    }

    private class KeyIterable implements Iterable<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    private class ValueIterator implements Iterator<V> {
        Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }
    }

    private class ValueIterable implements Iterable<V> {
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }
}
