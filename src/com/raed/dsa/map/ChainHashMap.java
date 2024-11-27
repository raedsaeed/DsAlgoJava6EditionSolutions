package com.raed.dsa.map;


import com.raed.dsa.chapter7list.ArrayList;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private UnsortedTableMap<K, V>[] table;

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(key);
    }

    @Override
    protected boolean bucketPut(int h, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            table[h] = new UnsortedTableMap<>();
            bucket = table[h];
        }

        int oldSize = bucket.size();
        bucket.put(key, value);
        length += (bucket.size() - oldSize);
        return true;
    }

    @Override
    protected boolean bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return false;
        int oldSize = bucket.size();
        boolean result = bucket.remove(k);
        length -= (oldSize - bucket.size());
        return result;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> entries = new ArrayList<>();
        for (UnsortedTableMap<K, V> map : table) {
            if (map == null) continue;

            for (Entry<K, V> entry : map.entrySet()) {
                entries.add(entry);
            }
        }

        return entries;
    }
}
