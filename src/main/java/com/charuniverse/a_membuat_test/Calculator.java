package com.charuniverse.a_membuat_test;

public class Calculator {
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer divide(Integer number, Integer divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Can NOT divide by zero");
        }
        return number / divisor;
    }
}