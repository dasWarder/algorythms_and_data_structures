package com.example.testing;


import com.example.testing.hashing.LinearHash;

import java.util.Random;

public class TestingApplication {

    public static void main(String[] args) {

        LinearHash linearHash = new LinearHash();

        Random random = new Random(30);

        for(int i = 0; i < 10; i++) {
            int randomValue = random.nextInt(30);
            linearHash.insert(randomValue);
        }

        linearHash.printTable();
        System.out.println("<--------------------------------------------->");
        linearHash.delete(4);

        linearHash.printTable();
        linearHash.insert(4);
        System.out.println("<--------------------------------------------->");

        linearHash.printTable();
    }

};

