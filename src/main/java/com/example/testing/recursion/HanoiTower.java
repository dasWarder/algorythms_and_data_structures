package com.example.testing.recursion;


/**
 * @author dasWarder
 */
public class HanoiTower {
    /*

    1
    2
    3
    A       B       C
     */
    public static void main(String[] args) {
        moveTower(3, 'A', 'B', 'C');
    }

    private static void moveTower(int numOfDisks, char from, char temp, char to) {

        if(numOfDisks == 1) {

            System.out.println("Disk " + numOfDisks + " moved from " + from + " to " + to);

        } else {

            moveTower(numOfDisks - 1, from, to, temp);
            System.out.println("Disk " + numOfDisks + " moved from " + from + " to " + temp);

            moveTower(numOfDisks - 1, temp, from, to);
            System.out.println("Disk " + numOfDisks + " moved from " + temp + " to " + from);
        }

    }

}
