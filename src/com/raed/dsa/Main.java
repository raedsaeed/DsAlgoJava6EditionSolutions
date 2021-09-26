package com.raed.dsa;

import com.raed.dsa.chapter6.impl.Utils;

public class Main {

    public static void main(String[] args) {
//        LinkedStack<String> stack = new LinkedStack<>();
//        stack.push("Raed");
//        stack.push("Naser");
//        stack.push("Ali");
//        stack.push("Ahmed");
//        stack.printElements();
//        System.out.println("Clearing now ");
//        stack.clear();
//        System.out.println("Stack size " + stack.size());
//        stack.printElements();

//        System.out.println("is matching " + Utils.isHTMLMatched("<body>\n" +
//                "<center attribute1=\"value1\" attribute2=\"value2\">\n" +
//                "<h1> The Little Boat </h1>\n" +
//                "</center>\n" +
//                "<p> The storm tossed the little\n" +
//                "boat like a cheap sneaker in an\n" +
//                "old washing machine. The three\n" +
//                "drunken fishermen were used to\n" +
//                "such treatment, of course, but\n" +
//                "not the tree salesman, who even as\n" +
//                "a stowaway now felt that he\n" +
//                "had overpaid for the voyage. </p>\n" +
//                "<ol>\n" +
//                "<li> Will the salesman die? </li>\n" +
//                "<li> What color is the boat? </li>\n" +
//                "<li> And what about Naomi? </li>\n" +
//                "</ol>\n" +
//                "</body>"));

        String equation = "((5+2)*(8-3))/4";
        System.out.println("Postfix notation for " + equation + " -> " + Utils.postfixNotation(equation));


        Object [] chars = {'A', 'B', 'C'};
        System.out.println("Subsets of it ");
        Utils.getAllPermutation(chars, 0);
//        Utils.permute(chars, 0);
    }
}
