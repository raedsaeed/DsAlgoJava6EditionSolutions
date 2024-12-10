package com.raed.dsa.map;


import com.raed.dsa.chapter7list.ArrayList;

import java.util.Objects;
import java.util.Random;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    private static final int DEFAULT_CAPACITY = 31;
    private static final int DEFAULT_PRIME = 109345121;
    private static final float LOAD_FACTOR = .5f;
    private final int prime;
    private final int scale;
    private final int shift;
    protected int capacity;
    protected int length = 0;

    public AbstractHashMap(int cap, int prime) {
        this.capacity = cap;
        this.prime = prime;
        Random random = new Random();
        scale = random.nextInt(prime - 1) + 1;
        shift = random.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, DEFAULT_PRIME);
    }

    public AbstractHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_PRIME);
    }

    @Override
    public V get(K key) {
        return bucketGet(hashKey(key), key);
    }

    @Override
    public boolean put(K k, V v) {
        boolean b = bucketPut(hashKey(k), k, v);
        if (length * 1f / capacity > LOAD_FACTOR)
            resize(2 * capacity - 1);
        return b;
    }

    @Override
    public boolean remove(K k) {
        return bucketRemove(hashKey(k), k);
    }

    @Override
    public int size() {
        return length;
    }

    private int hashKey(K k) {
        return ((Math.abs(scale * Objects.hashCode(k) + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K, V>> entries = new ArrayList<>(capacity);
        for (Entry<K, V> entry : entrySet()) {
            entries.add(entry);
        }

        this.capacity = newCap;
        createTable();
        for (Entry<K, V> entry : entries) {
            bucketPut(hashKey(entry.getKey()), entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    protected abstract void createTable();

    protected abstract V bucketGet(int h, K key);

    protected abstract boolean bucketPut(int h, K key, V value);

    protected abstract boolean bucketRemove(int h, K k);
}
