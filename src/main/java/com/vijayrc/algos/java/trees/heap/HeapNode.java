package com.vijayrc.algos.java.trees.heap;


import com.vijayrc.algos.java.utilities.Print;
import com.vijayrc.algos.java.utilities.Printable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class HeapNode<T extends Comparable> implements Printable {
    public T value;
    public HeapNode<T> right;
    public HeapNode<T> left;
    public HeapStrategy strategy;
    public HeapNode(HeapStrategy strategy) {this.strategy = strategy;}
    public HeapNode(T t, HeapStrategy strategy) {this.value = t; this.strategy = strategy;}

    public void insert(T t) {
        if (value == null) {
            value = t;
            return;
        }
        if (right == null) {
            right = new HeapNode<T>(t, strategy);
            balance();
            return;
        } else if (left == null) {
            left = new HeapNode<T>(t, strategy);
            balance();
            return;
        }
        smallerChild().insert(t);
        balance();
    }
    public void balance() {
        strategy.balance(this);
        if (right != null) right.balance();
        if (left != null) left.balance();
    }
    public Boolean isLessThan(HeapNode<T> node) {return !(node == null || node.value == null) && node.value.compareTo(value) > 0;}
    public Boolean isMoreThan(HeapNode<T> node) {return !(node == null || node.value == null) && node.value.compareTo(value) < 0;}
    public List<Printable> printables() {return new ArrayList<Printable>(asList(right, left));}
    public void print() {new Print().with(this);}

    @Override
    public String toString() {return value != null ? value.toString() : "*";}

    private HeapNode<T> smallerChild() {
        if (right == null) return left;
        if (left == null) return right;
        if (right.childCount() < left.childCount()) return right;
        else return left;
    }
    public Integer childCount() {
        int count = 1;
        if (right != null) count += right.childCount();
        if (left != null) count += left.childCount();
        return count;
    }
    public T lastLeafValue() {
        HeapNode<T> node = this;
        HeapNode<T> parent = this;
        while (node.smallerChild() != null) {
            parent = node;
            node = node.smallerChild();
        }
        parent.removeChild(node);
        return node.value;
    }
    private void removeChild(HeapNode<T> node) {
        if (node.equals(left)) left = null;
        if (node.equals(right)) right = null;
    }
}

