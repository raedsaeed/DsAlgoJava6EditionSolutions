package com.raed.dsa.chapter1;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
public class R214 {
    public static void main(String[] args) {
        try {
            String[] arr = new String[2];
            arr[0] = "one";
            arr[1] = "two";
            System.out.println(arr[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Don’t try buffer overflow attacks in Java!");
        }
    }
}
