package com.me.DSA.graph.structures;

import java.util.*;

public class Graph<T> {
    private Map<T, Map<T, Integer>> adjacencyList;
    private boolean isUndirected = false;

    public Graph(boolean isUndirected) {
        this.isUndirected = isUndirected;
    }

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(T node) {
        adjacencyList.putIfAbsent(node, new HashMap<>());
    }


    public void addEdge(T source, T destination, int weight) {

        if(isUndirected)    weight = 0;

        adjacencyList.get(source).put(destination, weight);

        if(isUndirected)    adjacencyList.get(destination).put(source, weight);
    }

    public Set<T> getNodes() {
        return adjacencyList.keySet();
    }

    public Map<T, Integer> getNeighbors(T node) {
        return adjacencyList.getOrDefault(node, new HashMap<>());
    }
}

