package com.charuniverse.a_membuat_test;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    public static final Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        int result = calculator.add(5,15);
    }

}