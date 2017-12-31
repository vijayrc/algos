package com.vijayrc.algos.java.maps;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChainingMap<K, T> {
    private List<Bucket> buckets = new ArrayList<>();
    public ChainingMap<K, T> put(K key, T value) {
        Bucket bucket = new Bucket(key.hashCode());
        if (buckets.contains(bucket)) {
            buckets.get(buckets.indexOf(bucket)).add(key, value);
        } else {
            bucket.add(key, value); buckets.add(bucket);
        }
        return this;
    }
    public T find(K key) {
        Bucket bucket = new Bucket(key.hashCode());
        if (!buckets.contains(bucket)) return null;
        bucket = buckets.get(buckets.indexOf(bucket));
        return (T) bucket.find(key);
    }

    public class Mug<K, T> {
        private K key;
        private T value;
        public Mug(K key) {this.key = key;}
        public Mug(K key, T value) {this.key = key; this.value = value;}
        public T value() { return value; }
        @Override
        public int hashCode() {return key != null ? key.hashCode() : 0;}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Mug item = (Mug) o;
            return !(key != null ? !key.equals(item.key) : item.key != null);
        }
    }
    public class Bucket<K, T> {
        private Integer hash;
        private ArrayList<Mug> mugs = new ArrayList<>();
        public Bucket(Integer hash) {this.hash = hash;}
        public void remove(K key, T value) {mugs.remove(new Mug(key, value)); }
        public void add(K key, T value) {
            Mug mug = new Mug(key, value);
            mugs.remove(mug); mugs.add(mug);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bucket bucket = (Bucket) o;
            if (hash != null ? !hash.equals(bucket.hash) : bucket.hash != null) return false;
            return true;
        }
        @Override
        public int hashCode() {return hash != null ? hash.hashCode() : 0; }
        public T find(K key) {
            Mug toFind = new Mug(key);
            for (Mug mug : mugs)
                if(mug.equals(toFind)) return (T) mug.value();
            return null;
        }
    }
    public static class Zest {
        private ChainingMap<String, String> map;
        @Before
        public void setup() { map = new ChainingMap<>(); }
        @Test
        public void shouldWork() {
            map.put("C1","Kenny").put("C2","Kyle").put("C3","Cartman").put("C4","Butters");
            assertEquals("Kenny",map.find("C1"));
            map.put("C1","Token");
            assertEquals("Token",map.find("C1"));
        }
    }


}
