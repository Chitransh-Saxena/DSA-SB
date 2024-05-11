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


    public List<Integer> topoSortImproved(Map<Integer, List<Integer>> graph) {

        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> iterated = new Stack<>();
        Stack<Integer> inRecursion = new Stack<>();

        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {

            int node = entry.getKey();
            if(visited.contains(node))  continue;
            for(Integer child: entry.getValue()) {
                if(!topoImprovedDfs(child, graph, visited, iterated, inRecursion)) {
                    throw new IllegalArgumentException("There are cycles in graph");
                }
            }

        }

        while(!iterated.isEmpty()) {
            res.add(iterated.pop());
        }

        return res;

    }

    private boolean topoImprovedDfs(Integer node, Map<Integer, List<Integer>> graph, Set<Integer> visited, Stack<Integer> iterated, Stack<Integer> inRecursion) {

        // do not check for visited. I detect cycles via removing this logic
        visited.add(node);
        inRecursion.add(node);

        for(Integer child: graph.get(node)) {

            if(!visited.contains(child)) {
                if(!topoImprovedDfs(child, graph, visited, iterated, inRecursion)) {
                    return false;
                }
            } else if(inRecursion.contains(child)) {
                return false;
            }
        }

        inRecursion.remove(node);
        iterated.push(node);

        return true;
    }
}
