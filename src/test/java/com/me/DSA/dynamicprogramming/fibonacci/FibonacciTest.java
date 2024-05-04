package com.me.DSA.dynamicprogramming.fibonacci;

import com.me.DSA.dynamicprogramming.fibonacci.impl.BasicIntuitiveFibonacci;
import com.me.DSA.dynamicprogramming.fibonacci.impl.OverlappingSubproblemFibonacci;
import com.me.DSA.dynamicprogramming.fibonacci.impl.RecFibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @InjectMocks
    BasicIntuitiveFibonacci fibonacci;

    @InjectMocks
    RecFibonacci recFibonacci;

    @InjectMocks
    OverlappingSubproblemFibonacci memoizedFibonacci;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBasicSolution() {

        int n = 0;
        assertEquals(0, fibonacci.calculate(n));

        n = 1;
        assertEquals(0, fibonacci.calculate(n));

        n = 5;
        assertEquals(3, fibonacci.calculate(n));
    }

    @Test
    public void testRecSolution() {

        int n = 0;
        assertEquals(0, recFibonacci.calculate(n));

        n = 1;
        assertEquals(0, recFibonacci.calculate(n));

        n = 5;
        assertEquals(3, recFibonacci.calculate(n));
    }

    @Test
    public void testMemoisedSolution() {

        int n = 0;
        assertEquals(0, memoizedFibonacci.calculate(n));

        n = 1;
        assertEquals(0, memoizedFibonacci.calculate(n));

        n = 5;
        assertEquals(3, memoizedFibonacci.calculate(n));
    }
}
