package com.example.testing.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exponentiation {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {

        System.out.println("Result: " + exponentiationOfNumber());

    }



    private static long exponentiationOfNumber() {

        long numberForExponent = inputReading("Enter your number: ");
        long extent = inputReading("Enter extent for the number: ");

        closeReader();

        return recursionExponent(numberForExponent, extent);
    }

    private static long inputReading(String message) {


        Integer resultNumber = null;

        System.out.println(message);

        try {

            resultNumber = Integer.parseInt(reader.readLine());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            return (long) resultNumber;
        }
    }

    private static long recursionExponent(long numberForExponent, long extent) {

        if(extent == 1){

            return numberForExponent;
        }

        return recursionExponent(numberForExponent * numberForExponent, extent  / 2);
    }

    private static void closeReader() {

        try {

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }


}
