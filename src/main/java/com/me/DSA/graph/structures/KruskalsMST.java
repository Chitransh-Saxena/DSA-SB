package com.me.DSA.graph.structures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KruskalsMST {

    private class Edge {

        int v1;
        int v2;

        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    public int getMstWeight(int[][] graph) {

        int mstWeight = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            if ((o1.v1 == o2.v1 && o1.v2 == o2.v2) || (o1.v1 == o2.v2 && o1.v2 == o2.v1)) {
                return 0; // Both edges are equal
            }

            if (o1.v1 == o1.v2 || o2.v1 == o2.v2) {
                return 1; // Consider o1 > o2, ensuring self-edges are ignored
            }

            if (o1.v1 != o2.v1) {
                return Integer.compare(o1.v1, o2.v1);
            } else {
                return Integer.compare(o1.v2, o2.v2);
            }
        });

        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[0].length; j++) { // Start from i + 1 to avoid duplicate edges
                int weight = graph[i][j];
                if (weight != 0) { // Only add non-zero weighted edges
                    pq.add(new Edge(i, j, weight));
                }
            }
        }

        int[] roots = new int[graph.length];
        for(int i = 0; i<roots.length; i++) {
            roots[i] = i;
        }
        QuickUnion disjointSet = new QuickUnion(roots);
        int nodesInMst = 0;

        while(nodesInMst <= graph.length-1 && !pq.isEmpty()) {

            Edge e = pq.poll();
            if(e.v1 == e.v2)    continue;

            if(!disjointSet.connected(e.v1, e.v2)) {

                disjointSet.union(e.v1, e.v2);
                nodesInMst += 1;
                mstWeight += e.weight;
            }
        }

        if(nodesInMst != graph.length-1)    return -1;
        return mstWeight;
    }

}
