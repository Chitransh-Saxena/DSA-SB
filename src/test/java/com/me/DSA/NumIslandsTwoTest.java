package com.me.DSA;


import com.me.DSA.graph.questions.NumIslandsTwo;
import org.junit.jupiter.api.Test;

public class NumIslandsTwoTest {

    @Test
    public void testSuccess() {

        NumIslandsTwo test = new NumIslandsTwo();


        // test.numIslands2(3, 3, new int[][]{{0,0},{0,1},{1,2},{2,1}});
        test.numIslands2(2, 2, new int[][]{{0,0},{1,1},{0,1}});
    }
}
