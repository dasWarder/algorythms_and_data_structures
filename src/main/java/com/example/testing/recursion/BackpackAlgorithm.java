package com.example.testing.recursion;


/*
The main logic of this task is finding not an optimal solution, but an exact one, when there is possibilities to find a combination
of numbers that will be provide in sum right weight
 */
public class BackpackAlgorithm {

    private static int start = 0;

    public static void main(String[] args) {

        int[] backpack = new int[] { 11, 8, 7, 6, 5 };
        int weight = 45;
        int sum = 0;

       sum = find(backpack, weight, 0, 0);
       System.out.println(sum);
    }


    private static int find(int[] backpack, int weight, int sum, int index) {

        if(sum == weight) {

            return sum;

        }

        if(index >= backpack.length) {

            return 0;

        }

        int branch = recursionFind(backpack, weight, sum, index);

        return branch == 0? find(backpack, weight, sum, index + 1) : branch;
    }


    private static int recursionFind(int[] backpack, int weight, int sum, int index) {

        if(sum == weight) {

            return sum;

        }

        if(index == backpack.length) {

            return 0;
        }

        if(sum < weight) {

            sum = sum + backpack[index];

        } else {

            sum = sum - backpack[index - 1];
            index--;

        }

        return recursionFind(backpack, weight, sum, index + 1);
    }


}
