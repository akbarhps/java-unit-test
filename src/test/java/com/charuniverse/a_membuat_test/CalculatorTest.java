package com.charuniverse.a_membuat_test;

import com.charuniverse.b_display_name_generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@DisplayName("Test Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @Test
//    @DisplayName("Test calculator.add(a, b) success")
    public void testAddSuccess() {
        int result = calculator.add(5, 15);
        assertEquals(20, result);
    }

    @Test
//    @DisplayName("Test calculator.divide(a, b) success")
    public void testDivideSuccess() {
        int result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
//    @DisplayName("Test calculator.divide(a, b) throw IllegalArgumentException")
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(100, 0));
    }
}