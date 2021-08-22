package com.charuniverse.e_urutan_eksekusi_test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LifecycleTest {
    private int runCounter = 0;

    @BeforeAll
    void beforeAll() {
        System.out.println("Before all: " + runCounter);
    }

    @AfterAll
    void afterAll() {
        System.out.println("After all: " + runCounter);
    }

    @Test
    void testA() {
        runCounter++;
        System.out.println(runCounter);
    }

    @Test
    void testB() {
        runCounter++;
        System.out.println(runCounter);
    }
}