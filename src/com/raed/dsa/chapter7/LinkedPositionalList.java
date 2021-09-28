package com.raed.dsa.chapter7;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Raed Saeed on 26/09/2021
 **/
public class LinkedPositionalList<T> implements PositionalList<T> {
    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public LinkedPositionalList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<T> first() {
        return position(head.getNext());
    }

    @Override
    public Position<T> last() {
        return position(tail.getPrev());
    }

    @Override
    public Position<T> before(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<T> after(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position<T> addFirst(T element) {
        return addBetween(element, head, head.getNext());
    }

    @Override
    public Position<T> addLast(T element) {
        return addBetween(element, tail.getPrev(), tail);
    }

    @Override
    public Position<T> addBefore(Position<T> p, T element) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(element, node.getPrev(), node);
    }

    @Override
    public Position<T> addAfter(Position<T> position, T element) throws IllegalArgumentException {
        Node<T> node = validate(position);
        return addBetween(element, node, node.getNext());
    }

    @Override
    public T set(Position<T> position, T newElement) throws IllegalArgumentException {
        Node<T> node = validate(position);
        T temp = node.getElement();
        node.setElement(newElement);
        return temp;
    }

    @Override
    public T remove(Position<T> position) throws IllegalArgumentException {
        Node<T> node = validate(position);
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        T temp = node.getElement();
        node.setPrev(null);
        node.setNext(null);
        node.setElement(null);
        return temp;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Position<T> p) {
        int index = -1;
        if (validate(p) != null) {
            for (Position<T> position : positions()) {
                index++;
                if (p.getElement().equals(position.getElement())) break;
            }
        }
        return index;
    }

    @Override
    public Position<T> findPosition(T e) {
        Position<T> position = first();
        while (position != null) {
            if (position.getElement().equals(e)) return position;
            position = after(position);
        }
        return null;
    }

    private Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node<T> node)) throw new IllegalArgumentException("Invalid Position");
        if (node.getNext() == null)
            throw new IllegalArgumentException("Position is no longer in list");
        return node;
    }

    private Position<T> position(Node<T> node) {
        if (node == head || node == tail) return null;
        return node;
    }

    private Position<T> addBetween(T e, Node<T> prev, Node<T> next) {
        Node<T> newNode = new Node<>(e, prev, next);
        prev.setNext(newNode);
        next.setPrev(newNode);
        size++;
        return newNode;
    }

    public Iterable<Position<T>> positions() {
        return new PositionalIterable();
    }

    private static class Node<T> implements Position<T> {
        private Node<T> next;
        private Node<T> prev;
        private T element;

        public Node(T e, Node<T> prev, Node<T> next) {
            this.element = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public T getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private class PositionIterator implements Iterator<Position<T>> {
        private Position<T> cursor = first();
        private Position<T> recent = null;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<T> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("No element found");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        @Override
        public void remove() throws IllegalArgumentException {
            if (recent == null) throw new IllegalArgumentException("Nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionalIterable implements Iterable<Position<T>> {
        @Override
        public Iterator<Position<T>> iterator() {
            return new PositionIterator();
        }
    }

    private class ElementIterator implements Iterator<T> {
        Iterator<Position<T>> positionIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public T next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

}
