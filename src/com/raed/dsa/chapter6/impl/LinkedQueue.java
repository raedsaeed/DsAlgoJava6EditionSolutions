package com.raed.dsa.chapter6.impl;

import com.raed.dsa.chapter2.impl.LinkedList;
import com.raed.dsa.chapter2.impl.SingleLinkedList;

/**
 * Created by Raed Saeed on 17/09/2021
 **/
public class LinkedQueue<E> implements Queue<E> {
    protected final LinkedList<E> list;

    public LinkedQueue() {
        list = new SingleLinkedList<>();
    }

    public LinkedQueue(Stack<E> stack) {
        this();
        copy(stack);
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
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.getFirst();
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            list.clear();
        }
    }

    @Override
    public void copy(Stack<E> stack) {
        while (stack.top() != null) {
            enqueue(stack.pop());
        }
    }

    @Override
    public void copy(Queue<E> queue) {
        while (queue.first() != null) {
            enqueue(queue.dequeue());
        }
    }
}
