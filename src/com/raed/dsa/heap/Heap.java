package com.raed.dsa.heap;


import com.raed.dsa.chapter7list.ArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Raed Saeed on 14/11/2024
 */
public class Heap<T extends Comparable<T>> implements HeapADT<T> {
    private final ArrayList<T> list = new ArrayList<>();
    private Comparator<T> comparator;

    public Heap() {
        this(null, new DefaultComparator<>());
    }

    public Heap(Comparator<T> comparator) {
        this(null, comparator);
    }

    public Heap(T[] array, Comparator<T> comparator) {
        this.comparator = comparator;
        heap(array);
    }

    @SuppressWarnings("unchecked")
    public Heap(Collection<T> list) {
        T[] array = (T[]) new Object[list.size()];
        heap(list.toArray(array));
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        if (!isEmpty()) list.clear();
    }

    @Override
    public void add(T t) {
        list.add(t);
        upHeap(size() - 1);
    }

    @Override
    public T element(int index) {
        checkIndex(index);
        if (isEmpty()) return null;
        return list.get(index);
    }


    private void upHeap(int index) throws IllegalArgumentException {
        checkIndex(index);
        int child = index;
        int parent = parent(index);
        while (child > 0) {
            if (comparator.compare(element(index), element(parent)) < 0) {
                swap(index, parent);
                child = parent;
                parent = parent(parent);
            } else {
                break;
            }
        }
    }


    private void downHeap(int index) throws IllegalArgumentException {
        checkIndex(index);
        int parent = index;
        while (parent < size() - 1) {
            int smallestIndex = hasLeft(parent) ? left(parent) : parent;
            if (hasRight(parent)) {
                if (comparator.compare(element(right(parent)), element(smallestIndex)) < 0) {
                    smallestIndex = right(parent);
                }
            }

            if (comparator.compare(element(parent), element(smallestIndex)) > 0) {
                swap(parent, smallestIndex);
                parent = smallestIndex;
            } else {
                break;
            }
        }
    }


    private void heap(T[] array) {
        if (array != null) {
            for (T t : array) {
                list.add(t);
            }

            int i = size() - 1;
            while (i >= 0) {
                downHeap(i);
                i--;
            }
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        T item = element(0);
        swap(0, size() - 1);
        list.remove(size() - 1);
        downHeap(0);
        return item;
    }

    @Override
    public int parent(int index) throws IllegalArgumentException {
        checkIndex(index);
        return ((Math.abs(index - 1)) / 2);
    }

    @Override
    public int left(int index) throws IllegalArgumentException {
        int left = 2 * index + 1;
        if (left < size()) return left;
        return -1;
    }

    @Override
    public int right(int index) throws IllegalArgumentException {
        int right = 2 * index + 2;
        if (right < size()) return right;
        return -1;
    }

    @Override
    public boolean hasLeft(int index) throws IllegalArgumentException {
        return left(index) != -1;
    }

    @Override
    public boolean hasRight(int index) throws IllegalArgumentException {
        return right(index) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) throw new IllegalArgumentException("Invalid Index " + index);
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static class DefaultComparator<T> implements Comparator<T> {
        @Override
        @SuppressWarnings("unchecked")
        public int compare(T o1, T o2) throws ClassCastException {
            return ((Comparable<T>) o1).compareTo(o2);
        }
    }
}
