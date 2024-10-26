package com.raed.dsa.chapter2oodesign.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class CircularSingleLinkedList<T> implements CircleLinkedList<T> {
    private Node<T> tail;
    private int size;

    public CircularSingleLinkedList() {

    }

    public static void main(String[] args) {
        CircularSingleLinkedList<String> list = new CircularSingleLinkedList<>();
        list.addFirst("Raed");
        list.addLast("Nasser");
        list.addLast("Ali");
        list.addLast("Ahmed");
        list.addLast("Saeed");
        list.printElements();
        System.out.println("********** Reversing ***************** ");
        list.reverse();
        list.printElements();
        System.out.println("List has element Raed : " + list.contain("Raed"));
        System.out.println("*************** Deleting last element " + list.removeLast() + " *************** ");
        list.printElements();
        System.out.println("List has element Raeds : " + list.contain("Mahmouds"));
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
    public T getFirst() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            tail = new Node<>(element,  null);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(element, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    @Override
    public T removeFirst() {
        if (tail == null) return null;
        Node<T> firstNode = tail.getNext();
        Node<T> secondFirst = firstNode.getNext();
        tail.setNext(secondFirst);
        size--;
        return firstNode.getElement();
    }

    @Override
    public T removeLast() {
        if (tail == null) return null;
        Node<T> walk = tail.getNext();
        while(walk.getNext() != tail) {
            walk = walk.getNext();
        }
        T element = tail.getElement();
        walk.setNext(tail.getNext());
        tail = walk;
        size--;
        return element;
    }

    @Override
    public boolean contain(T t) {
        if (isEmpty()) return false;
        Node<T> walk = tail.getNext();
        int step = 0;
        while (step < size() && walk != null) {
            if (walk.element == t) return true;
            walk = walk.getNext();
            step++;
        }
        return false;
    }

    @Override
    public void printElements() {
        printElements(size());
    }

    @Override
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = tail.getNext();
        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        tail = prev;
    }

    @Override
    public void clear() {
        if (isEmpty()) return;
        while (size() > 0) {
            removeFirst();
        }
        tail = null;
    }

    @Override
    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void printElements(int size) {
        for (int i = 0; i < size; i++) {
            rotate();
            System.out.println(tail.getElement());
        }
    }

    public boolean hasSameSequence(CircularSingleLinkedList<T> other) {
        if (tail == null || other.tail == null) return false;

        Node<T> first = tail.getNext();
        Node<T> firstStartingPoint = null;
        Node<T> last = tail;
        Node<T> otherStartingPoint = other.tail.getNext();
        Node<T> otherLast = other.tail;

        while (first != null) {
            if (otherStartingPoint != null && first.getElement() == otherStartingPoint.getElement()) {
                firstStartingPoint = first;
                break;
            }

            first = first.getNext();
            if (first == last.getNext()) break;
        }

        while (firstStartingPoint != null && otherStartingPoint != null && firstStartingPoint != last.getNext() && otherStartingPoint != otherLast.getNext()) {
            if (firstStartingPoint.getElement() != otherStartingPoint.getElement()) return false;

            firstStartingPoint = firstStartingPoint.getNext();
            otherStartingPoint = otherStartingPoint.getNext();
        }

        return true;
    }

    private Node<T> getByIndex(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Index " + index + ", List size is " + size);
        if (isEmpty()) return null;
        Node<T> node = tail.getNext();
        for (int i = 0; i != index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void splitInto2() {
        Node<T> t1First = tail.getNext();
        Node<T> t1Last = getByIndex(size / 2);
        CircularSingleLinkedList<T> l1 = new CircularSingleLinkedList<>();
        while (t1First.getElement() != null && t1First.getElement() != t1Last.getElement()) {
            l1.addLast(t1First.getElement());
            t1First = t1First.getNext();
        }
        System.out.println("First list");
        l1.printElements(l1.size);

        Node<T> t2First = getByIndex(size / 2);
        Node<T> t2Last = tail.getNext();
        CircularSingleLinkedList<T> l2 = new CircularSingleLinkedList<>();
        while (t2First.getElement() != null && t2First.getElement() != t2Last.getElement()) {
            l2.addLast(t2First.getElement());
            t2First = t2First.getNext();
        }
        System.out.println("Second list");
        l2.printElements(l2.size);
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
