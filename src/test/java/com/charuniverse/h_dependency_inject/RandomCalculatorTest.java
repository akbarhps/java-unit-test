package com.charuniverse.h_dependency_inject;

import com.charuniverse.i_pewarisan_test.AbstractCalculatorTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
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

    @RepeatedTest(
            value = 10,
            name = "{displayName} iterasi ke {currentRepetition} dari total {totalRepetitions}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }

    @RepeatedTest(value = 10)
    void testRandomRepeatInfo(Random random, RepetitionInfo info) {
        System.out.println(info.getCurrentRepetition() + " from " + info.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Calculator Value Source")
    @ParameterizedTest(name = "{displayName} jalan dengan parameter {0}")
    @ValueSource(ints = {1, 22, 3, 4, 5})
    void testCalculatorValueSource(int value) {
        int expected = value + value;
        int result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("Test Calculator Method Source")
    @ParameterizedTest(name = "{displayName} jalan dengan parameter {0}")
    @MethodSource(value = {"parameterSource"})
    void testCalculatorMethodSource(int value) {
        int expected = value + value;
        int result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}