package com.raed.dsa.map;


import com.raed.dsa.chapter7list.ArrayList;
import com.raed.dsa.chapter7list.Position;
import com.raed.dsa.tree.search.AVLTree;

import java.util.Comparator;

/**
 * Created by Raed Saeed on 09/12/2024
 */
public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedTable<K, V> {
    private final AVLTree<Entry<K, V>> tree = new AVLTree<>();
    private Comparator<K> comp = null;

    public TreeMap() {
        this(new DefaultComparator<>());
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comparator) {
        this.comp = comparator;
    }

    /**
     * Get size of the current map
     *
     * @return size of tree - 1 divided by 2 to remove sentinels count
     */
    @Override
    public int size() {
        return (tree.size() - 1) / 2;
    }

    /**
     * Return whether the key exists or not
     *
     * @param key given to be searched for
     * @return true if key exist, false if not
     */
    @Override
    public boolean contains(K key) {
        Position<Entry<K, V>> p = search(key);
        return tree.isInternal(p);
    }


    @Override
    public V get(K key) {
        Position<Entry<K, V>> p = search(key);
        if (tree.isExternal(p)) return null;
        return p.getElement().getValue();
    }

    @Override
    public boolean put(K k, V v) {
        Position<Entry<K, V>> p = search(k);
        if (tree.isExternal(p)) {
            expandPosition(p, k, v);
            tree.balanceInsert(p);
            return false;
        }

        tree.set(p, new Entry<>(k, v));
        return true;
    }

    /**
     * Removes the entry with the specified key, if present returns true
     * Otherwise return false
     *
     * @param k the key whose entry is to be removed from the map
     * @return true or false
     */
    @Override
    public boolean remove(K k) {
        Position<Entry<K, V>> p = search(k);
        if (tree.isExternal(p)) return false;

        // p has internal children so replace it with the most value near to it
        if (tree.isInternal(tree.left(p)) && tree.isInternal(tree.right(p))) {
            Position<Entry<K, V>> replacement = treeMax(tree.left(p));
            tree.set(p, replacement.getElement());
            p = replacement;
        }
        Position<Entry<K, V>> leaf = tree.isExternal(tree.left(p)) ? tree.left(p) : tree.right(p);
        Position<Entry<K, V>> sibling = tree.sibling(leaf);

        // remove the leaf and position
        tree.remove(leaf);
        tree.remove(p);
        // after deletion of p node, now sibling is promoted to its parent and has to be rebalanced
        tree.balanceDelete(sibling);
        return true;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        for (Position<Entry<K, V>> p : tree.inorder())
            if (tree.isInternal(p)) buffer.add(p.getElement());
        return buffer;
    }

    /**
     * perform search for a given key and returns it's corresponding value
     *
     * @param key of the node entry
     * @return value corresponding to this key, otherwise returns relative position for this key
     */
    private Position<Entry<K, V>> search(K key) {
        return search(tree.root(), key);
    }

    /**
     * Perform binary search with the tree using the given key and start node e.g root
     *
     * @param p   start position of the tree
     * @param key of the node entry
     * @return value corresponding to this key, otherwise returns relative position for this key
     */
    private Position<Entry<K, V>> search(Position<Entry<K, V>> p, K key) {
        if (tree.isExternal(p)) return p;
        int result = comp.compare(key, p.getElement().getKey());
        if (result == 0) return p;
        if (result < 0) return search(tree.left(p), key);
        return search(tree.right(p), key);
    }


    /**
     * Expand the current tree node by add two new sentinel children
     *
     * @param p     given position to be modified by new entry and expanded with 2 sentinel children
     * @param key   new entry key to placed
     * @param value new entry value to be placed
     */
    private void expandPosition(Position<Entry<K, V>> p, K key, V value) {
        tree.set(p, new Entry<>(key, value));
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }


    /**
     * Get the maximum node of a tree start at position p
     *
     * @param position the start position
     * @return a tree position with greatest key in this tree
     */
    private Position<Entry<K, V>> treeMax(Position<Entry<K, V>> position) {
        Position<Entry<K, V>> walk = position;
        while (tree.isInternal(walk))
            walk = tree.right(walk);
        return tree.parent(walk);
    }

    /**
     * Get the minimum node of a tree start at position p
     *
     * @param position the start position
     * @return a tree position with lowest key in this tree
     */
    private Position<Entry<K, V>> treeMin(Position<Entry<K, V>> position) {
        Position<Entry<K, V>> walk = position;
        while (tree.isInternal(walk))
            walk = tree.left(walk);
        return tree.parent(walk);
    }

    @Override
    public Comparator<K> comparator() {
        return comp;
    }

    @Override
    public Entry<K, V> first() {
        if (isEmpty()) return null;
        return treeMin(tree.root()).getElement();
    }

    @Override
    public Entry<K, V> last() {
        if (isEmpty()) return null;
        return treeMax(tree.root()).getElement();
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        return null;
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        return null;
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
