package com.vijayrc.algos.java.probs;

import java.util.*;
import com.vijayrc.algos.java.lists.Queue;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * BABAABAZBABAABAZ
 * TODO looks incomplete
 */
public class LZW {
    private Map<Integer, String> table = new HashMap<>();
    private List<Integer> codes = new ArrayList<>();

    public void compress(String input) {
        int code = 1;
        int length = input.length();

        Queue<String> queue = new Queue<>();
        for (int i = 0; i < length; i++)
            queue.put(input.charAt(i) + "");

        String p = queue.get();
        while (!queue.isEmpty()) {
            String c = queue.get();
            if (table.containsValue(p + c)) {
                p = p + c;
            } else {
                table.put(code, p + c);
                codes.add(getCode(p));
                code++;
                p = c;
            }
        }
    }
    private Integer getCode(String p) {
        return null;
    }
    public List<Integer> codes() {return codes; }
    public static class LZWTest {
        @Test
        public void shouldWork() {
            LZW lzw = new LZW();
            String input = "BABAABAZBABAABAZ";
            lzw.compress(input);
            assertNotNull(lzw.codes());
        }
    }

}
