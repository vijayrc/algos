package com.vijayrc.algos.java.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class SortTest {
    private Sort sort;
    protected void plug(Sort sort) {this.sort = sort;}
    @Test
    public void shouldSortStrings() {
        List<String> actual = new ArrayList(asList("Kyle", "Cartman", "Kenny", "Stan", "Butters", "Clyde", "Token", "Wendy", "Bebe", "Timmy", "Jimmy"));
        List<String> expected = new ArrayList(asList("Bebe", "Butters", "Cartman", "Clyde", "Jimmy", "Kenny", "Kyle", "Stan", "Timmy", "Token", "Wendy"));
        sort.on(actual);
        assertEquals(expected, actual);
    }
    @Test
    public void shouldSortNumbers() {
        List<Integer> actual = asList(66, 11, 44, 55, 22, 99, 222, 77, 33, 111, 88);
        List<Integer> expected = asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222);
        sort.on(actual);
        assertEquals(expected, actual);
    }
}
