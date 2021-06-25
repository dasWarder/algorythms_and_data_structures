package com.example.testing.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    private static int size;
    private static int count;
    private static char[] lettersArray;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String word = readLine();
        initArrayAndSize(word.length());
        populateArray(word);
        doAnagram(size);

    }

    private static String readLine() throws IOException {

        System.out.println("Enter your word: ");

        String res = null;
        res = reader.readLine();

        reader.close();

        return res;
    }


    private static void initArrayAndSize(int length) {

        lettersArray = new char[length];
        size = length;

    }

    private static void populateArray(String word) {

        for(int i = 0; i < word.length(); i++) {

            lettersArray[i] = word.charAt(i);

        }

    }

    private static void doAnagram(int size) {

        if(size == 1) {
            return;
        }

        for(int i = 0; i < size; i++) {

            doAnagram(size - 1);

            if(size == 2) {

                display();

            }

            rotate(size);

        }
    }

    private static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = lettersArray[position];

        for(j = position + 1; j < size; j++) {

            lettersArray[j - 1] = lettersArray[j];

        }

        lettersArray[j - 1] = temp;

    }

    private static void display() {
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < size; i++) {
            buffer.append(lettersArray[i]);
        }

        System.out.println(buffer.toString());
    }
}
