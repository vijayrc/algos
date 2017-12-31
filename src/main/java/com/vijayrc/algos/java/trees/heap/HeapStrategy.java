package com.vijayrc.algos.java.trees.heap;

public interface HeapStrategy {
    public void balance(HeapNode node);

    public static class Max<T extends Comparable> implements HeapStrategy {
        @Override
        public void balance(HeapNode node) {
            if (node.isLessThan(node.right)) swapValues(node, node.right);
            if (node.isLessThan(node.left)) swapValues(node, node.left);
        }
        private void swapValues(HeapNode<T> a, HeapNode<T> b) {
            T temp = a.value; a.value = b.value; b.value = temp;
        }
    }
    public static class Min<T extends Comparable> implements HeapStrategy {
        @Override
        public void balance(HeapNode node) {
            if (node.isMoreThan(node.right)) swapValues(node, node.right);
            if (node.isMoreThan(node.left)) swapValues(node, node.left);
        }
        private void swapValues(HeapNode<T> a, HeapNode<T> b) {
            T temp = a.value; a.value = b.value; b.value = temp;
        }
    }

}
