package com.example.testing.stack;

import com.example.testing.stack.simple.CustomStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleStackImpl {

    public static void main(String[] args) {
        int indexOfNumber = getInputNumber();

        System.out.println("The result is: " + countNumber(indexOfNumber));
    }


    private static Integer getInputNumber() {

        System.out.println("Enter your number: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer numberForCounting = null;

        try {

            numberForCounting = Integer.parseInt(
                                                 reader.readLine());

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            return numberForCounting;
        }
    }

    private static long countNumber(int indexOfNumber) {

        CustomStack stack = new CustomStack(indexOfNumber);
        long result = 0;

       while(indexOfNumber > 0) {

           stack.push((long) indexOfNumber);
           --indexOfNumber;
       }

        while(!stack.isEmpty()) {

            result += stack.pop();
        }

        return result;
    }
}
