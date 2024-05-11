package com.me.DSA.graph;

import com.me.DSA.graph.structures.KruskalsMST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MSTTest {


    @Test
    public void kruskalMstTest() {


        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };


        int expectedMSTWeight = 16;


        KruskalsMST kruskalMST = new KruskalsMST();
        int actualMSTWeight = kruskalMST.getMstWeight(graph);


        assertEquals(expectedMSTWeight, actualMSTWeight);
    }
}
