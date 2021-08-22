package com.charuniverse.f_nested_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    private Queue<String> queue;

    @Nested
    public class WhenOffer {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        void testWhenOfferSizeMustBeIncreasing() {
            queue.offer("Hello");
            Assertions.assertEquals(1, queue.size());
        }
    }
}