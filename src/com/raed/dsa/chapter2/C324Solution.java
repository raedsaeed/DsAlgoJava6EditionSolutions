package com.raed.dsa.chapter2;

/**
 * Created by Raed Saeed on 8/23/2021
 **/

/*
Write a Java method that takes two three-dimensional integer arrays and adds
them componentwise.
 */
public class C324Solution {
    public static void main(String[] args) {
        int[][] twoDimen = new int[2][3];
        System.out.println("Sum is " + add(twoDimen));
    }

    public static int add(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}
