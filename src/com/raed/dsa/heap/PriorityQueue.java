package com.raed.dsa.heap;


import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Raed Saeed on 14/11/2024
 */
public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueADT<T> {
    private final Heap<T> heap;

    public PriorityQueue() {
        heap = new Heap<>();
    }

    public PriorityQueue(Comparator<T> comparator) {
        heap = new Heap<>(comparator);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }

    @Override
    public void add(T element) {
        heap.add(element);
    }

    @Override
    public T front() {
        return heap.element(0);
    }

    @Override
    public T peek() {
        return heap.peek();
    }
}
