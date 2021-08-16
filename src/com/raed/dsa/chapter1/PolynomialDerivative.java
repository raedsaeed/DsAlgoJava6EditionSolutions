package com.raed.dsa.chapter1;

import java.util.Scanner;

/**
 * Created by Raed Saeed on 8/16/2021
 **/
class PolynomialDerivative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Equation");
        String equation = scanner.nextLine();
        System.out.println("Enter value ");
        String value = scanner.nextLine();
        System.out.println("Answer is " + derivative(equation, value));

        // test equation 4x^3 + 3x^1 + 2x^2
    }

    static int derivative(String equation, String xValue) {
        int x;
        if (xValue == null || xValue.isEmpty()) {
            x = 1;
        } else {
            x = Integer.parseInt(xValue);
        }

        String[] equs = equation.split("\\+|-|\\*|/");
        int answer = 0;
        for (String s : equs) {
            answer += getAnswer(s.trim(), x);
        }

        return answer;
    }

    static int getAnswer(String pro, int xValue) {
        int numberBeforeX = 1;
        int power = 1;
        String[] numberBeforeXAndPower = pro.replaceAll("[^0-9]", " ")
                .split("\\s+", 2);

        if (numberBeforeXAndPower.length < 2) {
            return 0;
        }

        numberBeforeX = (!numberBeforeXAndPower[0].isEmpty()) ? Integer.parseInt(numberBeforeXAndPower[0].trim()) : 1;
        power = (!numberBeforeXAndPower[1].isEmpty()) ? Integer.parseInt(numberBeforeXAndPower[1].trim()) : 1;

        return (int) (numberBeforeX * power * Math.pow(xValue, power - 1));
    }
}
