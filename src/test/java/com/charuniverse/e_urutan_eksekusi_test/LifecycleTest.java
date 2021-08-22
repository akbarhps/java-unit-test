package com.charuniverse.e_urutan_eksekusi_test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {
    private int runCount = 0;

    @Test
    void testA() {
        runCount++;
    }

    @Test
    void testB() {
        System.out.println(runCount);
    }
}