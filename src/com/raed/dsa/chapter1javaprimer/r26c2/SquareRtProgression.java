package com.raed.dsa.chapter1javaprimer.r26c2;

/**
 * Created by Raed Saeed on 8/16/2021
 **/
public class SquareRtProgression extends Progression<Double> {
    public SquareRtProgression(Double start) {
        super(start);
    }

    @Override
    void sequence() {
        current = Math.sqrt(current);
    }
}
