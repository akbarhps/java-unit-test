package com.charuniverse.i_pewarisan_test;

import com.charuniverse.a_membuat_test.Calculator;
import com.charuniverse.h_dependency_inject.RandomParameterResolver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {
    protected final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Abstract Calculator Test Start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Abstract Calculator Test End");
    }
}