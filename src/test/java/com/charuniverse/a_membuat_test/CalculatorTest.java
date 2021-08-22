package com.charuniverse.a_membuat_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        int result = calculator.add(5, 15);
        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess() {
        int result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(100, 0));
    }
}