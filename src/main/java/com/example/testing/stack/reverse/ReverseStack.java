package com.example.testing.stack.reverse;

import com.example.testing.stack.simple.CustomStack;

public class ReverseStack {
    private String input;
    private CustomStack customStack;

    public ReverseStack(String input) {
        this.input = input;
        customStack = new CustomStack(input.length());
    }

    public String reverseString() {

        pushStringLettersToStack();
        String reversedString = getReversedLettersFromStack();

        return reversedString;
    }

    private void pushStringLettersToStack() {

        for(int i = 0; i < input.length(); i++) {
            customStack.push(Long.valueOf(input.charAt(i)));
        }
    }

    private String getReversedLettersFromStack() {

        String output = "";

        while(!customStack.isEmpty()) {
            long elementPrimitive = customStack.pop();
            char element = (char) elementPrimitive;
            output += element;
        }

        return output;
    }
}
