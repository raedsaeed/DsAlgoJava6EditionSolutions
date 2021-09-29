package com.raed.dsa.chapter7;

import com.raed.dsa.chapter6.impl.Queue;

import java.util.Iterator;

/**
 * Created by Raed Saeed on 28/09/2021
 **/
public class LinkedPositionalQueue<T> implements Queue<T> {
    private final LinkedPositionalList<T> data;

    public LinkedPositionalQueue() {
        data = new LinkedPositionalList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(T t) {
        data.addLast(t);
    }

    public Position<T> enqueuePosition(T t) {
        return data.addLast(t);
    }

    public T remove(Position<T> position) {
        return data.remove(position);
    }

    @Override
    public T dequeue() {
        if (data.first() != null) {
            return data.remove(data.first());
        }
        return null;
    }

    @Override
    public T first() {
        if (data.first() != null) {
            return data.first().getElement();
        }
        return null;
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private final Iterator<T> iterator = data.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
