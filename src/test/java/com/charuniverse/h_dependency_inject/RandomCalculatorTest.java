package com.charuniverse.h_dependency_inject;

import com.charuniverse.i_pewarisan_test.AbstractCalculatorTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
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
}