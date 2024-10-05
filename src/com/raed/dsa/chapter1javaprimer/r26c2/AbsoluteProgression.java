package com.raed.dsa.chapter1javaprimer.r26c2;

/**
 * Created by Raed Saeed on 8/16/2021
 **/
public class AbsoluteProgression extends Progression<Long> {
    private long previous;

    public AbsoluteProgression() {
        this(2, 200);
    }

    public AbsoluteProgression(int first, int second) {
        super((long) first);
        previous = first - second;
    }

    @Override
    void sequence() {
        long temp = previous;
        previous = current;
        current = Math.abs(previous - temp);
    }
}
