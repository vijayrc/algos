package com.vijayrc.algos.java.trees.avl;

import com.vijayrc.algos.java.trees.nodes.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Version 1 - Balances only across top 3 nodes (root, A, B).
 * This is good for random data, but unsuited for nearly sorted data.
 *
 *                         R
 *                      A    B
 *                    A1 A2 B1 B2
 *
 *         Rotate left
 *                          B
 *                       R     B2
 *                     A   B1
 *                  A1   A2
 *
 *         Rotate right
 *                        A
 *                    A1     R
 *                        A2    B
 *                            B1  B2
 *
 *
 */
public class AVLTree1<T extends Comparable> {
    private Node<T> root = new Node<>();

    public void insert(T t) {
        root.insert(t);
        balance();
    }
    private void balance() {
        int r = 0, l = 0, d;
        if (root.right != null) r = root.right.height();
        if (root.left != null) l = root.left.height();
        d = r - l;
        if (Math.abs(d) <= 1) return;
        if (d > 0) rotateLeft();
        if (d < 0) rotateRight();
    }
    private void rotateLeft() {
        Node<T> A = root.left;
        Node<T> B = root.right;
        Node<T> R = new Node<>(root.value());
        R.left = A;
        R.right = B.left;
        root = B;
        root.left = R;
    }
    private void rotateRight() {
       Node<T> A = root.left;
       Node<T> B = root.right;
       Node<T> R = new Node<>(root.value());
       R.left = A.right;
       R.right = B;
       root = A;
       root.right = R;
    }
    public void print() {root.print();}

    public static class Zest {
        private AVLTree1<Integer> tree = new AVLTree1<>();
        @Test
        public void shouldBalanceForRandomInput() {
            for (Integer no : asList(1, 6, 3, 5, 8, 4, 2, 7, 10, 9, 8))
                tree.insert(no);
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
