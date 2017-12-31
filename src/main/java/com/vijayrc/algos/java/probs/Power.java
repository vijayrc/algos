package com.vijayrc.algos.java.probs;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Power {
    private Double value;
    public Power(Double value) {this.value = value;}
    public Double of(Integer power) {return recurse(value, power);}
    private Double recurse(Double value, Integer power) {
        if(power == 1) return value;
        if(power <= 0) return 1d;
        Double x = recurse(value, power / 2);
        if (power % 2 == 0) return x * x;
        else return value * x * x;
    }
    public static class Zest {
        @Test
        public void shouldWork() {
            assertEquals(new Power(2d).of(3), 8d);
            assertEquals(new Power(16d).of(2), 256d);
            assertEquals(new Power(2d).of(0), 1d);
            assertEquals(new Power(2d).of(1), 2d);
            assertEquals(new Power(3d).of(4), 81d);
            assertEquals(new Power(13d).of(2), 169d);
            assertEquals(new Power(5d).of(4), 625d);
        }
    }
}
