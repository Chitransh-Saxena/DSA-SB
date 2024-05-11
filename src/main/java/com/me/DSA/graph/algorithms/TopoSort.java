package com.me.DSA.graph.algorithms;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopoSort {


    // Given a graph, provide a list of elements in topologically sorted order
    public List<Integer> sort(Map<Integer, List<Integer>> graph) {

        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> iterated = new Stack<>();

        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {

            int node = entry.getKey();
            traverseChildren(node, visited, iterated, graph);
        }

        while(!iterated.isEmpty()) {
            res.add(iterated.pop());
        }

        return res;

    }

    private void traverseChildren(int node, Set<Integer> visited, Stack<Integer> iterated, Map<Integer, List<Integer>> graph) {

        if(visited.contains(node))  return;
        visited.add(node);

        // For it to be completely iterated, and put into stack, it's children have to be visited and iterated.
        for(Integer child: graph.get(node)) {
            traverseChildren(child, visited, iterated, graph);
        }

        iterated.push(node);
    }
}
