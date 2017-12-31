package com.vijayrc.algos.java.lists;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    public int size() {
        int count = 0;
        for (Node<T> node = head; node != null;) {
            count++; node = node.next;
        }
        return count;
    }
    public LinkedList<T> add(T t) {
        Node<T> item = new Node<>(t);
        if (head == null) {
            head = item; tail = head; return this;
        }
        tail.next = item; tail = item; return this;
    }
    public LinkedList<T> remove(T t) {
        Node<T> toRemove = new Node<>(t);
        if (toRemove.equals(head)) head = head.next;
        for (Node<T> node = head; node != null;) {
            if (toRemove.equals(node.next)) {
                node.next = node.next.next; break;
            }
            node = node.next;
        }
        return this;
    }
    public static class Zest {
        private LinkedList<String> list = new LinkedList<>();
        @Test
        public void shouldAddAndRemoveItem() {
            list.add("Cartman").add("Kyle").add("Kenny").remove("Kyle");
            assertTrue(list.size() == 2);
            list.add("Jimmy").add("Butters").remove("Cartman");
            assertTrue(list.size() == 3);
            list.remove("Butters");
            assertTrue(list.size() == 2);
        }
    }
}
