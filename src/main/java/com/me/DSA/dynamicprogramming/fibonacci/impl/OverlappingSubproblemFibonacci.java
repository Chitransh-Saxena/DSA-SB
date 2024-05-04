package com.me.DSA.dynamicprogramming.fibonacci.impl;

import com.me.DSA.dynamicprogramming.fibonacci.Fibonacci;
import org.springframework.stereotype.Service;

import java.util.Arrays;


// Also called Memoisation
@Service
public class OverlappingSubproblemFibonacci implements Fibonacci {


    @Override
    public long calculate(int n) {

        if(n == 0)  return 0;

        long[] res = new long[n+1];
        Arrays.fill(res, -1);
        return getMemoisedFib(res, n-1);
    }

    private long getMemoisedFib(long[] res, int n) {

        if (n <= 1) {
            return n;
        }
        if (res[n] == -1) {
            res[n] = getMemoisedFib(res, n-1) + getMemoisedFib(res, n-2);
        }

        return res[n];
    }
}
