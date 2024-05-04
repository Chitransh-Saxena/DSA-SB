package com.me.DSA.dynamicprogramming.fibonacci.impl;

import com.me.DSA.dynamicprogramming.fibonacci.Fibonacci;
import org.springframework.stereotype.Service;

@Service
public class RecFibonacci implements Fibonacci {


    @Override
    public long calculate(int n) {

        if(n == 0 || n == 1)  return 0;
        if(n == 2)  return 1;
        return calculate(n-1) + calculate(n-2);
    }
}
