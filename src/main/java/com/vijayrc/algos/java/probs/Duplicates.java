package com.vijayrc.algos.java.probs;

import com.vijayrc.algos.java.sort.InsertionSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class Duplicates<T extends Comparable> {
    public void withSort(List<T> input) {
        new InsertionSort<T>().on(input);
        for (int j = input.size() - 1; j > 0; j--)
            if (input.get(j).compareTo(input.get(j - 1)) == 0)
                input.remove(j);
    }
    public void withoutSort(List<T> input) {
        for (int i = input.size() - 1; i >= 0; i--)
            for (int j = i - 1; j >= 0; j--)
                if (input.get(j).compareTo(input.get(i)) == 0) { input.remove(i); break; }
    }
    public static class Zest {
        Duplicates<String> duplicates = new Duplicates<>();
        @Test
        public void shouldWorkWithSort() {
            List<String> actual = new ArrayList<>(); actual.addAll(asList("A", "A", "B", "C", "X", "C", "B"));
            List<String> expected = new ArrayList<>(); expected.addAll(asList("A", "B", "C", "X"));
            duplicates.withSort(actual);
            assertEquals(expected, actual);
        }
        @Test
        public void shouldWorkWithoutSort() {
            List<String> actual = new ArrayList<>(); actual.addAll(asList("A", "A", "B", "C", "X", "C", "B"));
            List<String> expected = new ArrayList<>(); expected.addAll(asList("A", "B", "C", "X"));
            duplicates.withoutSort(actual);
            assertEquals(expected, actual);
        }
    }
}
