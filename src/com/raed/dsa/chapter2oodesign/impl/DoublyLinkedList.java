package com.raed.dsa.chapter2oodesign.impl;

/**
 * Created by Raed Saeed on 8/20/2021
 **/
public class DoublyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list1 = new DoublyLinkedList<>();
        list1.addLast("Raed");
        list1.addLast("Ali");
        list1.addLast("Ahmed");
        list1.addLast("Saeed");
        System.out.println("Before reversing");
        list1.printElements();
        System.out.println("After reversing");
        list1.reverse();
        list1.printElements();
//        System.out.println(list1.getLast());
//        System.out.println(list2.getFirst());
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return head.getNext().getElement();
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    @Override
    public void addFirst(T element) {
        addBetween(element, head, head.getNext());
    }

    @Override
    public void addLast(T element) {
        addBetween(element, tail.getPrev(), tail);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        return removeNode(head.getNext());
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        return removeNode(tail.getPrev());
    }

    @Override
    public boolean contain(T t) {
        if (isEmpty()) return false;
        Node<T> node = head;
        while (node.getNext() != null) {
            if (node.getElement() == t) return true;
            node = node.getNext();
        }
        return false;
    }

    private void addBetween(T element, Node<T> previous, Node<T> next) {
        Node<T> newNode = new Node<>(element, previous, next);
        previous.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    private T removeNode(Node<T> node) {
        Node<T> previous = node.getPrev();
        Node<T> next = node.getNext();
        previous.setNext(next);
        next.setPrev(previous);
        size--;
        return node.getElement();
    }

    public void printElements() {
        Node<T> node = head.getNext();
        while (node != null && node.getElement() != null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }
    }

    @Override
    public void reverse() {
        Node<T> current = head.getNext();
        Node<T> last = head.getNext();
        Node<T> prev = null;

        head.setNext(tail.getPrev());
        while (current.getNext() != null) {
            Node<T> next = current.getNext();
            current.setNext(prev);
            current.setPrev(next);
            prev = current;
            current = next;
        }
        tail.setPrev(last);
    }

    @Override
    public void clear() {
        while (size() > 0) removeFirst();
        head = tail = null;
    }

    public DoublyLinkedList<T> concatenate(DoublyLinkedList<T> other) {
        if (other == null) return this;
        if (isEmpty()) {
            head = other.head;
        } else {
            // lets take tail
            Node<T> middle = other.head.getNext();
            middle.setPrev(tail.getPrev());
            tail.setElement(middle.getElement());
            tail.setNext(middle.getNext());
        }
        tail = other.tail;
        size += other.size;
        return this;
    }

    public int getNormalSize() {
        Node<T> first = head.getNext();
        if (first == tail) return 0;
        int size = 0;
        while (first != null) {
            size++;
            first = first.getNext();
            if (first == tail) break;
        }
        return size;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
