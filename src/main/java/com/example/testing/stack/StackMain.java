package com.example.testing.stack;

import com.example.testing.stack.brackets.BracketChecker;

public class StackMain {

    public static void main(String[] args) {
        BracketChecker bracketChecker = new BracketChecker();

        boolean bracketsAreCorrect = bracketChecker.isBracketsAreCorrect("a{()}");

        System.out.println(bracketsAreCorrect);
    }
}
