package com.raed.dsa.chapter1javaprimer.r26c2;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
public class R26R27 {
    public static void main(String[] args) {
        FibonacciProgression fibonacciProgression = new FibonacciProgression("1.367", "1.536");
        System.out.println("Fibonacci Sequence");
        fibonacciProgression.printSequence(100);

//        System.out.println("Arithmetic Sequence");
//        progression = new ArithmeticProgression(2, 0);
//        progression.printSequence(128);
//
        Progression<Long> progression = new AbsoluteProgression();
        progression.printSequence(10);

        Progression<Double> sqProgression = new SquareRtProgression(65356.0);
        sqProgression.printSequence(10);
    }

}

