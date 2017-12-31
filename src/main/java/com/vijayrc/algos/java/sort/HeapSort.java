package com.vijayrc.algos.java.sort;

import com.vijayrc.algos.java.trees.heap.HeapStrategy;
import com.vijayrc.algos.java.trees.heap.HeapTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 *Not stable
  O(1) extra space
  O(n�lg(n)) time
  Not really adaptive
 */
public class HeapSort<T extends Comparable> {
    public List<T> desc(List<T> list) { return sort(list, new HeapStrategy.Max<T>());}
    public List<T> asc(List<T> list) { return sort(list, new HeapStrategy.Min<T>());}

    private List<T> sort(List<T> list, HeapStrategy strategy) {
        HeapTree<T> tree = new HeapTree<>(strategy);
        for (T t : list) tree.add(t);
        tree.print();
        List<T> sorted = new ArrayList<>();
        T item;
        while ((item = tree.remove()) != null) sorted.add(item);
        return sorted;
    }

    public static class Zest {
        private HeapSort<Integer> sort = new HeapSort<>();
        @Test
        public void shouldWork() {
            List<Integer> input = asList(1, 5, 7, 8, 3, 4, 2, 6, 9, 11, 12, 10);
            assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), sort.asc(input));
            assertEquals(asList(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1), sort.desc(input));
        }
    }
}
