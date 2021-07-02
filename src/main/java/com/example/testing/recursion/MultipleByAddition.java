package com.example.testing.recursion;

public class MultipleByAddition {

    public static void main(String[] args) {
        System.out.println(mult(5, 12));
    }

    private static int mult(int x, int y) {

        int times = y;
        int multiplayer = x;

        return recursionSum(multiplayer, times, 0);
    }

    private static int recursionSum(int multiplayer,  int power, int sum) {

        if (power == 0) {

            return sum;

        }

        sum += multiplayer;

        return recursionSum(multiplayer, power - 1, sum);
    }
}
