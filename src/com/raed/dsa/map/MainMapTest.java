package com.raed.dsa.map;


/**
 * Created by Raed Saeed on 27/11/2024
 */
public class MainMapTest {
    public static void main(String[] args) {
        ChainHashMap<Integer, String> map = new ChainHashMap<>();
        map.put(1, "Saeed");
        map.put(2, "Ahmed");
        map.put(3, "Ali");
        map.put(4, "Nasser");
        map.put(5, "Raed");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
    }
}
