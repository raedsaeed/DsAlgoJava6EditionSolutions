package com.raed.dsa.tree.array;


/**
 * Created by Raed Saeed on 14/11/2024
 */
public class TreeMainTest {
    public static void main(String[] args) {
        ArrayBinaryIndexableTree<String> family = new ArrayBinaryIndexableTree<>();
        family.addRoot("Saeed");
        family.addLeft(0, "Ahmed");
        family.addRight(0, "Ali");
        family.addLeft(1, "Nasser");
        family.addLeft(1, "Raed");

        System.out.println("********* Pre Order *********");
        for(String member : family.preorder()) {
            System.out.println(member);
        }


        System.out.println("******** Post Order *****");
        for (String member : family.postorder()) {
            System.out.println(member);
        }
    }
}
