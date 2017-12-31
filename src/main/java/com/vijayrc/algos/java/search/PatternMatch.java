package com.vijayrc.algos.java.search;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PatternMatch {
    //O(n*m)
    public Integer count(String input, String pattern) {
        int match = 0;
        int n = input.length();
        int p = pattern.length();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == pattern.charAt(0)) {
                for (int j = 0; (i + j) < n && j < p; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j)) break;
                    if (j == (p - 1)) match++;
                }
            }
        }
        return match;
    }
    public static class Zest {
        @Test
        public void shouldMatch() {
            PatternMatch patternMatch = new PatternMatch();
            assertTrue(patternMatch.count("ABAABABBAB", "AB") == 4);
            assertTrue(patternMatch.count("ABAABABBAB", "ABA") == 2);
            assertTrue(patternMatch.count("ABAABABABAB", "BABA") == 2);
        }
    }
}
