package com.raed.dsa.chapter2.impl;

/**
 * Created by Raed Saeed on 8/20/2021
 **/
public class DoublyLinkedList<T> {
    private final Node<T> head;
    private final Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addFirst("Naser");
        list.addFirst("Raed");
        list.addLast("Saeed");
        list.removeFirst();
        list.removeLast();
        list.addFirst("Raed");
        list.addLast("Saeed");
        list.printElements();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return head.getNext().getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    public void addFirst(T element) {
        linkList(element, head, head.getNext());
    }

    public void addLast(T element) {
        linkList(element, tail.getPrev(), tail);
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        return unLinkList(head.getNext());
    }

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
}
