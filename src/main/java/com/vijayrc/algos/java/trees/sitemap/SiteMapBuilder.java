package com.vijayrc.algos.java.trees.sitemap;

import com.vijayrc.algos.java.lists.Queue;
import com.vijayrc.algos.java.sort.InsertionSort;
import com.vijayrc.algos.java.utilities.Print;
import com.vijayrc.algos.java.utilities.Printable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertNotNull;

public class SiteMapBuilder {
    public SiteMapNode on(List<String> urls) {
        new InsertionSort().on(urls);
        SiteMapNode root = new SiteMapNode("/", "/");
        for (String url : urls)
            root.add(url);
        return root;
    }
    public class SiteMapNode implements Printable {
        private String url;
        private String value;
        private Map<String, SiteMapNode> children = new HashMap<>();

        public SiteMapNode(String url, String value) {this.url = url;this.value = value;}
        public List<Printable> printables() {return new ArrayList<Printable>(children.values());}
        public void print() {new Print().with(this);}

        public void add(String url) {
            String[] splits = url.split("/");
            Queue<String> tokens = new Queue<>();
            for (String split:splits) tokens.put(split);
            recurse(tokens, url);
        }
        public void recurse(Queue<String> tokens, String url) {
            if (tokens.isEmpty()) return;
            String key = tokens.get();
            if (!children.containsKey(key))children.put(key, new SiteMapNode(url, key));
            children.get(key).recurse(tokens, url);
        }
        @Override
        public String toString() {return value+"=>"+url;}
    }

    public static class Zest {
        @Test
        public void shouldWork() {
            SiteMapNode root = new SiteMapBuilder().on(asList("/1/11/112", "/1/11/111", "/1/11", "/1", "/1/12/111", "/1/12",
                    "/1/12/112", "/2/22/221", "/2/22", "/2", "/2/21", "/2/21/221"));
            assertNotNull(root);
            root.print();
        }
    }
}
