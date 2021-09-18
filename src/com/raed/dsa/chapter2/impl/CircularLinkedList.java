package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/19/2021
 **/
public class CircularLinkedList<T> implements CircleLinkedList<T> {
    private Node<T> tail;
    private int size;

    public CircularLinkedList() {

    }

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.addFirst("Raed");
        list.addLast("Naser");
        list.addLast("Ali");
        list.addLast("Mahmoud");
        list.addLast("Ahmed");
        list.addLast("Saeed");
        list.addLast("Mohamed");
        System.out.println("First list ....");
        list.printElements();
        System.out.println("Clearing list now ");
        list.clear();
        System.out.println("First " + list.getFirst());
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
            tail = new Node<>(element, null, null);
            tail.setNext(tail);
            tail.setPrev(tail);
        } else {
            Node<T> newNode = new Node<>(element, tail, tail.getNext());
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
        Node<T> last = tail;
        Node<T> preLast = last.getPrev();
        Node<T> firstElement = last.getNext();
        firstElement.setPrev(preLast);
        preLast.setNext(firstElement);
        tail = preLast;
        size--;
        return last.getElement();
    }

    @Override
    public boolean contain(T t) {
        return false;
    }

    @Override
    public void printElements() {
        printElements(size());
    }

    @Override
    public void reverse() {

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

    public int getNormalSize() {
        if (tail == null) return size;
        Node<T> first = tail.getNext();
        Node<T> last = tail;
        int size = 0;

        while (first != null) {
            size++;
            first = first.getNext();
            if (first == last.getNext()) break;
        }

        return size;
    }

    public boolean hasSameSequence(CircularLinkedList<T> other) {
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

    public Node<T> getByIndex(int index) {
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
        CircularLinkedList<T> l1 = new CircularLinkedList<>();
        while (t1First.getElement() != null && t1First.getElement() != t1Last.getElement()) {
            l1.addLast(t1First.getElement());
            t1First = t1First.getNext();
        }
        System.out.println("First list");
        l1.printElements(l1.size);

        Node<T> t2First = getByIndex(size / 2);
        Node<T> t2Last = tail.getNext();
        CircularLinkedList<T> l2 = new CircularLinkedList<>();
        while (t2First.getElement() != null && t2First.getElement() != t2Last.getElement()) {
            l2.addLast(t2First.getElement());
            t2First = t2First.getNext();
        }
        System.out.println("Second list");
        l2.printElements(l2.size);
    }
}
