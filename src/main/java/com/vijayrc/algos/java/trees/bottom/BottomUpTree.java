package com.vijayrc.algos.java.trees.bottom;



import com.vijayrc.algos.java.trees.nodes.BigNode;
import com.vijayrc.algos.java.utilities.Print;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class BottomUpTree<T extends Comparable> {
    private BigNode<T> root;
    private Integer leaves;
    public BottomUpTree(Integer leaves) {this.leaves = leaves;}

    public BigNode<T> on(List<T> list) {
        List<BigNode<T>> nodes = new ArrayList<>();
        for (T item : list) nodes.add(new BigNode<>(item));
        recurse(nodes);
        return root;
    }
    private void recurse(List<BigNode<T>> nodes) {
        List<BigNode<T>> subNodes = new ArrayList<>();
        if (nodes.size() <= leaves) {
            root = new BigNode<>();
            for (BigNode<T> node : nodes) root.addChild(node);
            return;
        }
        for (int i = 0; (i + leaves) <= nodes.size(); i = i + leaves) {
            BigNode<T> join = new BigNode<>();
            for (int j = 0; j < leaves; j++)
                join.addChild(nodes.get(i + j));
            subNodes.add(join);
        }
        if (nodes.size() % leaves != 0)
            subNodes.add(nodes.get(nodes.size() - 1));
        recurse(subNodes);
    }
    public void print() {new Print().with(root);}

    public static class Zest {
        private BottomUpTree<String> tree = new BottomUpTree<>(3);
        @Test
        public void shouldWork() {
            BigNode<String> root = tree.on(Arrays.asList("Bebe", "Butters", "Cartman", "Clyde","Jimmy", "Kenny", "Kyle", "Stan", "Timmy", "Token", "Wendy"));
            assertNotNull(root);
            tree.print();
        }
    }
}
