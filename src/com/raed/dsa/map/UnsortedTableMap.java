package com.raed.dsa.map;


import com.raed.dsa.chapter7list.ArrayList;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private final ArrayList<Entry<K, V>> table;

    public UnsortedTableMap() {
        table = new ArrayList<>();
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(K key) {
        return findIndex(key) != -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index == -1 || index >= size())
            return null;
        return table.get(index).getValue();
    }

    @Override
    public boolean put(K k, V v) {
        int index = findIndex(k);
        if (index == -1) {
            table.add(new Entry<>(k, v));
            return true;
        }

        if (index < size()){
            table.get(index).setValue(v);
        }
        return true;
    }

    @Override
    public boolean remove(K k) {
        int index = findIndex(k);
        if (index == -1 || index == size()) return false;
        swap(index, table.size() - 1);
        table.remove(table.size() - 1);
        return true;
    }

    private void swap(int i, int j) {
        Entry<K, V> temp = table.get(i);
        table.set(i, table.get(j));
        table.set(j, temp);
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < table.size();
        }

        @Override
        public Entry<K, V> next() {
            return table.get(j++);
        }
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    private int findIndex(K key) {
        int j = 0;
        while (j < table.size()) {
            if (table.get(j).getKey().equals(key)) return j;
            j++;
        }
        return -1;
    }
}
