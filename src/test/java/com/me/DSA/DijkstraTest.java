package com.me.DSA;

import com.me.DSA.graph.structures.DijkstraAlgorithm;
import com.me.DSA.graph.structures.Graph;
import org.junit.Assert;
import org.junit.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {


    @Test
    public void testBasicDijkstra() {

        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 1);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.run("A");

        assertEquals(2, dijkstra.getShortestDistance("B"));
        assertEquals(3, dijkstra.getShortestDistance("C"));

    }

    @Test
    public void testDisconnectedGraph() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.run("A");

        assertEquals(Integer.MAX_VALUE, dijkstra.getShortestDistance("B"));
        System.out.println("Since node is disconnected, there is no distance between the nodes, thus infinity - " + Integer.MAX_VALUE);
    }

    // Test for negative weighted edges
    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeWeightedEdges() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B", -1);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.run("A");
    }

    @Test
    public void testShortestPath() {

        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 1);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.run("A");


        List<String> path = dijkstra.getShortestPath("C");

        Assert.assertEquals(new String[]{"A", "B", "C"}, path.toArray());
        System.out.println(path);
    }



}
