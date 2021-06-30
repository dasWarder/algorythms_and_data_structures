package com.example.testing.sorting.merge;

public class MergeSortSimpleConceptualImplementation {


    public void sort(long[] first, int length) {
        System.out.println("Bad practice, but this method not supported. Use sortMerge instead");
    }

    public long[] sortMerge(long[] first, long[] second) {

        long[] last = new long[first.length + second.length];

        sorting(first, second, last);

        return last;
    }

    private void sorting(long[] first, long[] second, long[] last) {

        int countFirst = 0;
        int countSecond = 0;
        int countLast = 0;

        while( countFirst < first.length &&
                                         countSecond < second.length ) {

            if (first[countFirst] < second[countSecond]) {

                last[countLast++] = first[countFirst++];

            } else {

                last[countLast++] = second[countSecond++];
            }
        }

        cyclingAddingIfNotNull(countFirst, first, countLast, last);
        cyclingAddingIfNotNull(countSecond, second, countLast, last);
    }

    private void cyclingAddingIfNotNull(int counterArray, long[] array, int counterLast, long[] lastArray) {

        while( counterArray < array.length ) {

            lastArray[counterLast++] = array[counterArray++];
        }

    }

    public void sortingName() {
        System.out.println("Merge sorting strategy");
    }
}
