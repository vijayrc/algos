package com.vijayrc.algos.java.lists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Queue<T extends Object> {
    private Node<T> head;
    private Node<T> tail;
    public boolean isEmpty(){return head == null;}
    public Queue<T> put(T t) {
        Node<T> node = new Node<>(t);
        if (head == null) {
            head = node; tail = head; return this;
        }
        tail.next = node; tail = node; return this;
    }
    public T get() {
        if (head == null) return null;
        Node<T> pop = head;
        head = head.next;
        return pop.value();
    }
    public static class Zest {
        @Test
        public void shouldWork() {
            Queue<String> q = new Queue<>();
            q.put("A").put("B").put("C");
            assertEquals("A",q.get());
            assertEquals("B",q.get());
            assertEquals("C",q.get());
        }
    }


}
