package com.example.testing.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(computeFactorial(5));
    }


    private static long computeFactorial(int element) {

        if (element == 0) {
            return 1;
        }

        return element * computeFactorial(element - 1);
    }
}
