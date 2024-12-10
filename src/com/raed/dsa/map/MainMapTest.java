package com.raed.dsa.map;


/**
 * Created by Raed Saeed on 27/11/2024
 */
public class MainMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(4, "Nasser");
        map.put(2, "Ahmed");
        map.put(3, "Ali");
        map.put(1, "Saeed");
        map.put(5, "Raed");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }

//        int key = 2;
//        System.out.println("Ceiling returns the least key >= " + key + " : " + map.ceilingEntry(key).getKey());
//        System.out.println("Floor returns the greatest key <= " + key + " : " + map.floorEntry(key).getKey());
//        System.out.println("Higher returns the least key > " + key + " : " + map.higherEntry(key).getKey());
//        System.out.println("Lower returns the greatest key < " + key + " : " + map.lowerEntry(key).getKey());
    }
}
