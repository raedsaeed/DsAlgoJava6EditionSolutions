package com.raed.dsa.chapter2oodesign.impl;

import com.raed.dsa.chapter6stacksandqueue.impl.Deque;

/**
 * Created by Raed Saeed on 8/20/2021
 **/
public class DoublyLinkedList<T> implements Deque<T> {
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
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
//        list1.addLast("Raed");
//        list1.addLast("Ali");

        list2.addLast("Ahmed");
        list2.addLast("Saeed");
        list1.concatenate(list2).printElements();
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
        linkList(element, head, head.getNext());
    }

    @Override
    public void addLast(T element) {
        linkList(element, tail.getPrev(), tail);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        return unLinkList(head.getNext());
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        return unLinkList(tail.getPrev());
    }

    private void linkList(T element, Node<T> previous, Node<T> next) {
        Node<T> newNode = new Node<>(element, previous, next);
        previous.setNext(newNode);
        next.setPrev(newNode);
        size++;
    }

    private T unLinkList(Node<T> node) {
        Node<T> previous = node.getPrev();
        Node<T> next = node.getNext();
        previous.setNext(next);
        next.setPrev(previous);
        size--;
        return node.getElement();
    }

    public void printElements() {
        Node<T> node = head.getNext();
        while (node.getElement() != null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }
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
}
