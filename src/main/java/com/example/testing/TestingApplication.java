package com.example.testing;


import com.example.testing.hashing.ChainHash;

public class TestingApplication {

    public static void main(String[] args) {

        ChainHash<Integer> chainHash = new ChainHash<>();

        chainHash.insert(12);
        chainHash.insert(32);
        chainHash.insert(19);
        chainHash.insert(444);
        chainHash.insert(19);
        chainHash.printTable();
    }

};

