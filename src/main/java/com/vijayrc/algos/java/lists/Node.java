package com.vijayrc.algos.java.lists;

public class Node<T> {
    private T value;
    public Node prev;
    public Node next;
    public Node(T value) {this.value = value; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        if (value != null ? !value.equals(node.value) : node.value != null) return false;
        return true;
    }
    @Override
    public int hashCode() {return value != null ? value.hashCode() : 0;}
    public T value() {return value;}
}
