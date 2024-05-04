package com.me.DSA.dynamicprogramming.fibonacci.impl;

import com.me.DSA.dynamicprogramming.fibonacci.Fibonacci;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicIntuitiveFibonacci implements Fibonacci {


    @Override
    public long calculate(int n) {

        if(n == 0 || n == 1)  return 0;
        if(n == 2)  return 1;

        long f = 0;
        long s = 1;

        int count = 2;
        List<Long> fibs = new ArrayList<>();
        fibs.add(0L);
        fibs.add(1L);

        while(count < n) {

            long temp = f;
            f = s;
            s = (temp + s);
            fibs.add(s);
            count += 1;
        }

        return fibs.get(n-1);
    }
}
