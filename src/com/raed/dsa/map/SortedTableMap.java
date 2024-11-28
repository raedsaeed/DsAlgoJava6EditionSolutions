package com.raed.dsa.map;


import com.raed.dsa.chapter7list.ArrayList;

import java.util.Comparator;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public class SortedTableMap<K, V> extends AbstractMap<K, V> implements SortedTable<K, V> {
    private final ArrayList<Entry<K, V>> table = new ArrayList<>();
    private final Comparator<K> comparator;

    public SortedTableMap() {
        this(new DefaultComparator<>());
    }

    public SortedTableMap(Comparator<K> cm) {
        this.comparator = cm;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean contains(K key) {
        int index = findIndex(key);
        return isEquals(index, key);
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (isEquals(index, key))
            return table.get(index).getValue();
        return null;
    }

    @Override
    public boolean put(K k, V v) {
        int index = findIndex(k);
        if (isEquals(index, k)) {
            table.get(index).setValue(v);
            return true;
        }

        table.add(index, new Entry<>(k, v));
        return true;
    }

    @Override
    public boolean remove(K k) {
        int index = findIndex(k);
        if (isEquals(index, k))
            return table.remove(index) != null;
        return false;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return snapshot(0, null);
    }

    @Override
    public Comparator<K> comparator() {
        return comparator;
    }

    @Override
    public Entry<K, V> first() {
        return safeKey(0);
    }

    @Override
    public Entry<K, V> last() {
        return safeKey(size() - 1);
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        int index = findIndex(key);
        return safeKey(index);
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        int index = findIndex(key);
        return safeKey(index - 1);
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        int index = findIndex(key);
        if (isEquals(index, key))
            return safeKey(index + 1);

        Entry<K, V> entry = safeKey(index);
        while (index < size() && entry != null && comparator.compare(entry.getKey(), key) <= 0) {
            entry = safeKey(index++);
        }
        return entry;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        int index = findIndex(key);
        return safeKey(index - 1);
    }

    private Entry<K, V> safeKey(int index) {
        if (index >= 0 && index < size())
            return table.get(index);
        return null;
    }

    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
        int index = findIndex(fromKey);
        if (isEquals(index, fromKey)) return snapshot(index, toKey);
        return new ArrayList<>();
    }

    private Iterable<Entry<K, V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K, V>> snap = new ArrayList<>();
        if (startIndex >= size()) return snap;

        int j = startIndex;
        while (stop == null || comparator.compare(table.get(j).getKey(), stop) <= 0) {
            snap.add(table.get(j++));
            if (j >= size()) break;
        }
        return snap;
    }

    private int findIndex(K key) {
        int low = 0;
        int high = size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = comparator.compare(key, table.get(mid).getKey());
            if (result == 0) return mid;
            if (result < 0) high = mid - 1;
            if (result > 0) low = mid + 1;
        }
        return low;
    }

    private boolean isEquals(int index, K key) {
        return (index < size() && comparator.compare(key, table.get(index).getKey()) == 0);
    }

    @SuppressWarnings("unchecked")
    private static class DefaultComparator<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return ((Comparable<T>) o1).compareTo(o2);
        }
    }
}
