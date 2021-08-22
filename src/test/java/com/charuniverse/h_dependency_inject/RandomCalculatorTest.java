package com.charuniverse.h_dependency_inject;

import com.charuniverse.i_pewarisan_test.AbstractCalculatorTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomCalculatorTest extends AbstractCalculatorTest {
    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }
}