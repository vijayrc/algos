package com.vijayrc.algos.java.lists;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
/**
 * log2n doubling for n insertions if we start with a array of size 1
 * TODO fix growth and shrink logic, refer scala
 */
public class ArrayList<T> {
    private Object[] array;
    public ArrayList(Integer size) {this.array = new Object[size]; }
    public Integer size() { return array.length;}

    public ArrayList<T> add(T t) {
        if (addToArray(t)) return this;
        Object[] newArray = new Object[2 * array.length];
        for(int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        array = newArray;
        addToArray(t);
        return this;
    }
    private boolean addToArray(T t) {
        boolean isAdded = false;
        for (int i = 0; i < array.length; i++)
            if (array[i] == null) {
                array[i] = t;
                isAdded = true;
                break;
            }
        return isAdded;
    }

    public static class Zest {
        private ArrayList<String> list = new ArrayList<>(2);
        @Test
        public void shouldAddElement() {
            list.add("A").add("B").add("C").add("D");
            assertTrue(list.size() == 4);
        }
    }

}
