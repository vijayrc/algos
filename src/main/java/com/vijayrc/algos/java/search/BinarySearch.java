package com.vijayrc.algos.java.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * O(log(n) - base 2)
 */
public class BinarySearch<T extends Comparable> {
    public Integer find(T t, List<T> input) {
        return recurse(t, input, 0, input.size() - 1);
    }
    private Integer recurse(T t, List<T> input, int start, int end) {
        if (t.compareTo(input.get(start)) == 0) return start;
        if (t.compareTo(input.get(end)) == 0) return end;

        int mid = (end + start) / 2;
        int compare = t.compareTo(input.get(mid));
        if (compare < 0) return recurse(t, input, start, mid);
        if (compare == 0) return mid;
        if (compare > 0) return recurse(t, input, mid + 1, end);
        return -1;
    }
    public static class Zest {
        @Test
        public void shouldWork() {
            BinarySearch<String> bs = new BinarySearch<>();
            assertTrue(bs.find("B", asList("A", "B", "C", "D")) == 1);
            assertTrue(bs.find("C", asList("A", "B", "C", "D")) == 2);
            assertTrue(bs.find("D", asList("A", "B", "C", "D")) == 3);
        }
    }

}
