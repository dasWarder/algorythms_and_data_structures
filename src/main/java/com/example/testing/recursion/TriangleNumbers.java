package com.example.testing.recursion;

public class TriangleNumbers {

    public static void main(String[] args) {
        int result = getTriangleElement(8);
        System.out.println(result);
    }


    private static int getTriangleElement(int col) {

        if(col == 1) {
            return 1;
        }

        return col + getTriangleElement(col - 1);
    }
}
