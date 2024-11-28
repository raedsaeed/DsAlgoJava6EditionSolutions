package com.raed.dsa.map;


import java.util.Comparator;

/**
 * Created by Raed Saeed on 27/11/2024
 */
public interface SortedTable<K, V> extends Map<K, V> {
    Comparator<K> comparator();

    Map.Entry<K, V> first();

    Map.Entry<K, V> last();

    Map.Entry<K, V> floorEntry(K key);

    Map.Entry<K, V> ceilingEntry(K key);

    Map.Entry<K, V> higherEntry(K key);

    Map.Entry<K, V> lowerEntry(K key);
}
