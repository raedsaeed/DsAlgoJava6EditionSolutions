package com.raed.dsa.chapter8;

import com.raed.dsa.chapter7.Position;

import java.util.ArrayList;

/**
 * Created by Raed Saeed on 13/10/2021
 **/
public class TreeTraversalsApplications {

    /**
     * Prints preorder representation of subtree of T rooted at p having depth d.
     */
    public static <E> void printPreorderTreeIndent(Tree<E> tree, Position<E> p, int depth) {
        System.out.println(spaces(2 * depth) + p.getElement());
        for (Position<E> child : tree.children(p)) {
            printPreorderTreeIndent(tree, child, depth + 1);
        }
    }

    /**
     * Prints labeled representation of subtree of T rooted at p having depth d.
     */
    public static <E> void printPreorderTreeLabeled(Tree<E> tree, Position<E> p, ArrayList<Integer> path) {
        int d = path.size();
        System.out.println(spaces(2 * d));
        for (int j = 0; j < d; j++) System.out.println(path.get(j) + (j == d - 1 ? " " : "."));
        System.out.println(p.getElement());
        path.add(1);
        for (Position<E> child : tree.children(p)) {
            printPreorderTreeLabeled(tree, child, path);
            path.set(d, 1 + path.get(d));
        }
        path.remove(d);
    }

    public static String spaces(int length) {
        return " ".repeat(Math.max(0, length));
    }

    public static int diskSpace(Tree<Integer> tree, Position<Integer> p) {
        int subTotal = p.getElement();
        for (Position<Integer> child : tree.children(p)) {
            subTotal += diskSpace(tree, child);
        }
        return subTotal;
    }

    public static <E> void parenthesize(Tree<E> tree, Position<E> p) {
        System.out.println(p.getElement());
        if (tree.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> child : tree.children(p)) {
                System.out.println(firstTime ? " (" : ", ");
                firstTime = false;
                parenthesize(tree, child);
            }
        }
        System.out.println(")");
    }

//    public static <E> int layout(BinaryTree<E> tree, Position<E> p, int d, int x) {
//        if (tree.left(p) != null) x = layout(tree, tree.left(p), d + 1, x);
//        p.getElement().setX(x++);
//        p.getElement().setY(d);
//        if (tree.right(p) != null) x = layout(tree, tree.right(p), d + 1, x);
//        return x;
//    }


}
