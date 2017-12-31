package com.vijayrc.algos.java.sort;

import com.vijayrc.algos.java.trees.binary.BinaryTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 *
 * O(n�lg(n)) time
 */
public class BinarySort<T extends Comparable> {
    private BinaryTree<T> tree;
    public String inOrder() {return tree.inOrder();}
    public void print() {tree.print(); }
    public void on(List<T> list){
        tree = new BinaryTree<>();
        for (T t : list) tree.insert(t);
    }
    public static class Zest {
        private BinarySort<Integer> bs = new BinarySort<>();
        @Test
        public void shouldWork() {
            bs.on(asList(1, 6, 3, 5, 8, 4, 2, 9, 7));
            bs.print();
            assertEquals("123456789", bs.inOrder());

            bs.on(asList(4, 6, 3, 5, 8, 1, 2, 9, 7));
            bs.print();
            assertEquals("123456789", bs.inOrder());
        }
    }
}
