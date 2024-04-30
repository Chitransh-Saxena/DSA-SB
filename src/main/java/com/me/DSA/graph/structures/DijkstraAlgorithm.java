package com.me.DSA.graph.structures;

import java.util.*;

public class DijkstraAlgorithm<T> {
    private Graph<T> graph;
    private Map<T, Integer> distance;
    private Map<T, T> predecessor;

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    private static class NodeDistance<T> {
        T node;
        int distance;

        NodeDistance(T node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public void run(T startNode) {

        distance = new HashMap<>();
        predecessor = new HashMap<>();

        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        Set<T> visited = new HashSet<>();

        for(T node: graph.getNodes()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(startNode, 0);
        priorityQueue.add(new NodeDistance(startNode, 0));

        while(!priorityQueue.isEmpty()) {

            NodeDistance currNode = priorityQueue.poll();
            if(visited.contains(currNode.node)) continue;
            visited.add((T) currNode.node);


            for(Map.Entry<T, Integer> entry: graph.getNeighbors((T) currNode.node).entrySet()) {

                T neighbor = entry.getKey();
                int newDistance = currNode.distance + entry.getValue();

                if(newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    predecessor.put(neighbor, (T) currNode.node);

                    priorityQueue.add(new NodeDistance(neighbor, newDistance));
                }
            }
        }
    }

    public int getShortestDistance(T node) {
        return distance.getOrDefault(node, Integer.MAX_VALUE);
    }

    public List<String> getShortestPath(T targetNode) {
        List<String> path = new ArrayList<>();
        T currentNode = targetNode;
        while (predecessor.containsKey(currentNode)) {
            path.add(0, (String) currentNode);
            currentNode =  predecessor.get(currentNode);
        }
        if (!path.isEmpty()) {
            path.add(0, (String) currentNode);
        }
        return path;
    }
}