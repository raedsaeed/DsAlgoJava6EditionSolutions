package com.raed.dsa.chapter1javaprimer.r26c2;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
abstract public class Progression<T extends Number> {
    protected T current;

    public Progression(T start) {
        this.current = start;
    }

    protected T nextValue() {
        T answer = current;
        sequence();
        return answer;
    }

    abstract void sequence();

    public void printSequence(int count) {
        System.out.print(nextValue());
        for (int i = 0; i < count; i++) {
            System.out.print(", " + nextValue());
        }
        System.out.println();
    }
}
