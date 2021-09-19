package com.raed.dsa;

import com.raed.dsa.chapter6.impl.LinkedStack;

public class Main {

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Raed");
        stack.push("Naser");
        stack.push("Ali");
        stack.push("Ahmed");
        stack.printElements();
        System.out.println("Clearing now ");
        stack.clear();
        System.out.println("Stack size " + stack.size());
        stack.printElements();
    }
}
