package com.vijayrc.algos.java.lists;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    public Integer size() {
        int count = 0;
        for (Node<T> node = head; node != null; node = node.next) count++;
        return count;
    }
    public DoublyLinkedList<T> add(T t) {
        Node<T> node = new Node<>(t);
        if (head == null) {
            head = node; tail = head;
            return this;
        }
        node.prev = tail; tail.next = node;tail = node;
        return this;
    }
    public DoublyLinkedList<T> remove(T t) {
        Node<T> toRemove = new Node<T>(t);
        if (toRemove.equals(head)) {
            head = head.next;
            return this;
        }
        for (Node<T> node = head; node != null; node = node.next) {
            if (toRemove.equals(node.next)) {
                Node<T> temp = node.next.next;
                node.next = temp;
                if (temp != null) temp.prev = node;
                break;
            }
        }
        return this;
    }
    public void print() {
        StringBuilder print = new StringBuilder();
        for (Node<T> node = head; node != null; node = node.next)
            print.append(node.value().toString()).append("-");
        System.out.println("[" + print + "]");
    }
    public static class Zest {
        private DoublyLinkedList<String> list = new DoublyLinkedList<>();
        @Test
        public void shouldAddAndRemoveItems() {
            list.add("Cartman").add("Kyle").add("Kenny").remove("Kyle");
            assertTrue(list.size() == 2);
            list.add("Jimmy").add("Butters").remove("Cartman");
            assertTrue(list.size() == 3);
            list.remove("Butters");
            assertTrue(list.size() == 2);
        }
    }

}
