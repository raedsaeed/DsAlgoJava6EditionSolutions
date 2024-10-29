package com.raed.dsa.chapter6stacksandqueue.impl;


import com.raed.dsa.chapter2oodesign.impl.DoublyLinkedList;

/**
 * Created by Raed Saeed on 29/10/2024
 */
public class Dequeue<T> implements Deque<T> {
    private DoublyLinkedList<T> list;

    public Dequeue() {
        list = new DoublyLinkedList<>();
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
    public T first() {
        return list.first();
    }

    @Override
    public T last() {
        return list.last();
    }

    @Override
    public void addFirst(T t) {
        list.addFirst(t);
    }

    @Override
    public void addLast(T t) {
        list.addLast(t);
    }

    @Override
    public T removeFirst() {
        return list.removeFirst();
    }

    @Override
    public T removeLast() {
        return list.removeLast();
    }
}
