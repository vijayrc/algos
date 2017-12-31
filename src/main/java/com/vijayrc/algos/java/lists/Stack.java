package com.vijayrc.algos.java.lists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Stack<T> {
    private Node<T> tail;
    public Stack<T> push(T t) {
        Node<T> node = new Node<>(t);
        node.next = tail; tail = node;
        return this;
    }
    public T pop() {
        if (tail == null) return null;
        Node<T> toPop = tail;
        tail = tail.next;
        return toPop.value();
    }
    public static class Zest {
        @Test
        public void shouldWork() {
            Stack<String> stack = new Stack<>();
            stack.push("A").push("B").push("C");
            assertEquals("C",stack.pop());
            assertEquals("B",stack.pop());
            assertEquals("A",stack.pop());
        }
    }
}
