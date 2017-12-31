package com.vijayrc.algos.java.sort;

import org.junit.Before;

import java.util.List;

/**
 *
 * Sorted set grows from left.
 * Algorithm repeatedly identifies the smallest remaining unsorted element
 * and puts it at the end of the sorted portion of the array
 * Not stable
 * O(1) extra space
 * O(n2) comparisons
 * O(n) swaps
 * Not adaptive
 *
 * TODO this is wrong implementation, check out scala, this leads to more swaps
 */
public class SelectionSort<T extends Comparable> extends AbstractSort<T> {
    public void on(List<T> input) {
        for (int i = 0; i < input.size(); i++)
            for (int j = i + 1; j < input.size(); j++)
                if (input.get(j).compareTo(input.get(i)) < 0)
                    swap(input, j, i);
    }
    public static class Zest extends SortTest {
        @Before
        public void setup(){plug(new SelectionSort());}
    }
}
