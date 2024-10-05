package com.raed.dsa.chapter1javaprimer.r26c2;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
public class ArithmeticProgression extends Progression<Integer> {
    private final int inc;

    public ArithmeticProgression() {
        this(1, 0);
    }

    public ArithmeticProgression(int start) {
        this(0, start);
    }

    public ArithmeticProgression(int stepSize, int start) {
        super(start);
        inc = stepSize;
    }

    @Override
    void sequence() {
        current += inc;
    }
}
