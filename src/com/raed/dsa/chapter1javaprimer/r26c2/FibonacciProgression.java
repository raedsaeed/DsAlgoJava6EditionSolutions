package com.raed.dsa.chapter1javaprimer.r26c2;

import java.math.BigInteger;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
public class FibonacciProgression extends Progression<Number> {
    private BigInteger previous;

    public FibonacciProgression() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public FibonacciProgression(String first, String second) {
        this(new BigInteger(first), new BigInteger(second));
    }

    public FibonacciProgression(BigInteger first, BigInteger second) {
        super(first);
        previous = second.subtract(first);
    }


    @Override
    void sequence() {
        BigInteger temp = previous;
        previous = (BigInteger) current;
        current = ((BigInteger) current).add(temp);
    }
}
