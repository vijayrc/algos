package com.vijayrc.algos.java.trees.huffman;

import com.vijayrc.algos.java.trees.nodes.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertNotNull;

public class HuffmanTree<T extends Comparable> {
    private Node<T> root;

    public Node<T> on(List<T> list) {
        List<Node<T>> nodes = new ArrayList<Node<T>>();
        for (T t : list) nodes.add(new Node(t));
        recurse(nodes);
        return root;
    }
    private void recurse(List<Node<T>> nodes) {
        if (root != null) return;
        if (nodes.size() == 2) {
            root = new Node<>();
            root.left = nodes.get(0);
            root.right = nodes.get(1);
            return;
        }
        List<Node<T>> subNodes = new ArrayList<Node<T>>();
        for (int i = 0; i + 1 < nodes.size(); i = i + 2) {
            Node<T> join = new Node<T>();
            join.left = nodes.get(i);
            join.right = nodes.get(i + 1);
            subNodes.add(join);
        }
        if(nodes.size() % 2 != 0) subNodes.add(nodes.get(nodes.size() - 1));
        recurse(subNodes);
    }
    public void print() {root.print();}
    public String pathOf(T t) {return root.pathOf(t);}
    public Node<T> root() {return root;}

    public static class HuffmanTreeTest {
        private HuffmanTree<String> tree = new HuffmanTree<>();
        @Test
        public void shouldWork() {
            tree.on(asList("Bebe", "Butters", "Cartman", "Clyde", "Jimmy", "Kenny", "Kyle", "Stan", "Timmy", "Token", "Wendy"));
            assertNotNull(tree.root()); tree.print();
        }
    }
}
