package com.vijayrc.algos.java.trees.binary;

import com.vijayrc.algos.java.trees.nodes.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;
import static junit.framework.Assert.assertEquals;

public class BinaryTree<T extends Comparable> {
    private Node<T> root = new Node<T>();

    public Node<T> on(List<T> list) {
        recurse(list);
        return root;
    }

    public void recurse(List<T> list) {
        if (list.size() <= 2) {
            for (T t : list) root.insert(t);
            return;
        }
        int middleIndex = list.size() / 2;
        root.insert(list.get(middleIndex));
        recurse(list.subList(0, middleIndex));
        recurse(list.subList(middleIndex + 1, list.size()));
    }

    public T max() {
        Node<T> node = root;
        while (node.right != null) node = node.right;
        return node.value();
    }

    public T min() {
        Node<T> node = root;
        while (node.left != null) node = node.left;
        return node.value();
    }

    public boolean exists(T t) {
        return root.exists(t);
    }

    public String inOrder() {
        return root.inOrder();
    }

    public String preOrder() {
        return root.preOrder();
    }

    public String postOrder() {
        return root.postOrder();
    }

    public void insert(T t) {
        root.insert(t);
    }

    public void print() {
        root.print();
    }

    public Integer height() {
        return root.height();
    }

    public Integer occurrences(T t) {
        return root.occurrences(t);
    }

    public class BinaryTreeTest {
        private BinaryTree<Integer> tree;

        @Before
        public void setup() {
            tree = new BinaryTree<Integer>();
        }

        @Test
        public void shouldWork() {
            Node<Integer> root = tree.on(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            assertNotNull(root);
            tree.print();

            assertEquals(new Integer(1), tree.min());
            assertEquals(new Integer(9), tree.max());

            assertTrue(tree.exists(5));
            assertFalse(tree.exists(11));

            assertEquals("123456789", tree.inOrder());
            assertEquals("531248679", tree.preOrder());
            assertEquals("214376985", tree.postOrder());

            tree.insert(10);
            assertTrue(tree.exists(10));
            tree.print();

            assertEquals(new Integer(3), tree.height());
            tree.insert(11);
            tree.insert(12);
            tree.print();
            assertEquals(new Integer(5), tree.height());
        }

        @Test
        public void shouldReturnCount() {
            Node<Integer> root = tree.on(Arrays.asList(1, 2, 1, 3, 4, 5, 6, 1, 1, 7, 8, 9));
            assertNotNull(root);
            tree.print();
            assertEquals(new Integer(4),tree.occurrences(1));
        }

    }

}
