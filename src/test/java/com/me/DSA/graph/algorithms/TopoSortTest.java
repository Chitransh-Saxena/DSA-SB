package com.me.DSA.graph.algorithms;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopoSortTest {


    @Test
    public void basicSortTest() {


        TopoSort topo = new TopoSort();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(3));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, List.of(5));
        graph.put(4, List.of(7));
        graph.put(5, List.of(6,7));
        graph.put(6, List.of());
        graph.put(7, List.of(8));
        graph.put(8, List.of());


        List<Integer> sorted = topo.sort(graph);
        System.out.println(sorted);
    }
}
