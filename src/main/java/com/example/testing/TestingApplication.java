package com.example.testing;


import com.example.testing.heap.Heap;

public class TestingApplication {

    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>(6);

        heap.insert(5);
        heap.insert(32);
        heap.insert(12);
        heap.insert(2);
        heap.insert(45);
        heap.insert(4);

        heap.print();
    }

    public static int myAtoi(String s) {

        String withoutSpace = s.trim();


        int res = 0;

        res = withoutSpace.matches("^-.+$")? -1 : 1;

        String resultString = withoutSpace;
        boolean withWordsInTheEnd = withoutSpace.matches("^[-+]?[0-9]+(.+)?$");

        if(withWordsInTheEnd) {
            resultString = (withoutSpace.startsWith("-") || withoutSpace.startsWith("+"))?
                    withoutSpace.split("\\D")[1] :
                    withoutSpace.split("\\D")[0];
        } else {
            return 0;
        }


        try {
            res *= Integer.parseInt(resultString);
        } catch(Exception e) {
            res = res > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;

        } finally {
            return res;
        }
    }

};

