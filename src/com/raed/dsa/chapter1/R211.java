package com.raed.dsa.chapter1;

/**
 * Created by Raed Saeed on 8/15/2021
 **/
public class R211 {
    public static void main(String[] args) {

        Region east = new State();

        State md = new Maryland();

        Object obj = new Place();

        Place usa = new Region();

        md.printMe();
        east.printMe();
        ((Place) obj).printMe();
        obj = md;

        ((Maryland) obj).printMe();
        obj = usa;
        ((Place) obj).printMe();

        usa = md;
        usa.printMe();
    }

    static class Maryland extends State {
        Maryland() {}

        public void printMe() {
            System.out.println("Read it.");
        }
    }

    static class State extends Region {
        State() {}

        public void printMe() {
            System.out.println("Ship it.");
        }
    }

    static class Region extends Place {
        Region() {}

        public void printMe() {
            System.out.println("Box it.");
        }
    }

    static class Place {
        Place() {}

        public void printMe() {
            System.out.println("Buy it.");
        }
    }
}
