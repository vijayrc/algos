package com.vijayrc.algos.java.trees.avl;

import com.vijayrc.algos.java.trees.nodes.Node;
import org.junit.Test;

import static java.util.Arrays.asList;

public class AVLTree2<T extends Comparable> {
    private Node<T> root = new Node<>();
    public void print() {root.print();}
    public void insert(T t) { root.insert(t); root.balance();}

    public static class Zest {
        private AVLTree2<Integer> tree = new AVLTree2<>();
        @Test
        public void shouldBalanceForRandomInput() {
            for (Integer i : asList(1, 6, 3, 5, 8, 4, 2, 7, 10, 9, 8))
                tree.insert(i);
            tree.print();
        }
        @Test
        public void shouldNotBalanceForSortedInput() {
            for (int i = 0; i < 20; i++)
                tree.insert(i);
            tree.print();
        }
    }
}
