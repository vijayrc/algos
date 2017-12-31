package com.vijayrc.algos.java.trees.heap;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class HeapTree<T extends Comparable> {
    private HeapStrategy strategy;
    private HeapNode<T> root;

    public HeapTree(HeapStrategy strategy) {this.strategy = strategy;this.root = new HeapNode<>(strategy);    }
    public void add(T t) {checkRoot();root.insert(t);}
    public void print() {checkRoot();root.print();}
    private void checkRoot() {if (root == null) root = new HeapNode<>(strategy);}

    public T remove() {
        if (root == null) return null;
        T t = root.value;
        T v = root.lastLeafValue();
        if (t.equals(v)) {
            root = null;
        } else {
            root.value = v;
            root.balance();
        }
        return t;
    }

    public static class Zest {
        private HeapTree<Integer> tree;
        @Test
        public void shouldWorkForMax() {
            tree = new HeapTree<>(new HeapStrategy.Max());
            for (Integer item : asList(1, 6, 13, 3, 5, 8, 14, 4, 2, 9, 7, 10, 15, 11, 12, 0))
                tree.add(item);
            tree.print();
            assertTrue(tree.remove() == 15);
            assertTrue(tree.remove() == 14);
            assertTrue(tree.remove() == 13);
            assertTrue(tree.remove() == 12);
            tree.print();
        }
        @Test
        public void shouldWorkForMin() {
            tree = new HeapTree<>(new HeapStrategy.Min());
            for (Integer item : asList(1, 6, 13, 3, 5, 8, 14, 4, 2, 9, 7, 10, 15, 11, 12))
                tree.add(item);
            tree.print();
            assertTrue(tree.remove() == 1);
            assertTrue(tree.remove() == 2);
            assertTrue(tree.remove() == 3);
            assertTrue(tree.remove() == 4);
            tree.print();
        }
        @Test
        public void shouldReturnLastLeafValue() {
            HeapStrategy.Max strategy = new HeapStrategy.Max();
            tree = new HeapTree<>(strategy);
            for (Integer item : asList(1, 4, 3, 2, 7))
                tree.add(item);
            tree.print();
            assertTrue(tree.remove() == 7);
            assertTrue(tree.remove() == 4);
            tree.print();
            assertTrue(tree.remove() == 3);
            tree.print();
            assertTrue(tree.remove() == 2);
            assertTrue(tree.remove() == 1);
            tree.print();
        }
    }

}

