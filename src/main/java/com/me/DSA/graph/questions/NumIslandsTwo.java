package com.me.DSA.graph.questions;

import java.util.*;

public class NumIslandsTwo {

    private static class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair other = (Pair) obj;
            return row == other.row && col == other.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Pair>> map = new HashMap<>();
        int islands = 0;

        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            Pair p = new Pair(r, c);

            int islandGroup = isPairInExistingIslands(p, map);
            if (islandGroup != -1) {
                Set<Pair> set = map.get(islandGroup);
                set.add(p); // Add new pair to existing island's set
                map.put(islandGroup, set);
                res.add(islands); // Add current islands count to result
            } else {
                islands++;
                Set<Pair> newSet = new HashSet<>();
                newSet.add(p);
                map.put(islands, newSet);
                res.add(islands); // Add updated islands count to result
            }
        }

        return res;
    }

    public int isPairInExistingIslands(Pair p, Map<Integer, Set<Pair>> map) {
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Define directions: up, down, left, right

        for (int[] direction : directions) {
            int newRow = p.row + direction[0];
            int newCol = p.col + direction[1];
            Pair newPair = new Pair(newRow, newCol);

            for (Map.Entry<Integer, Set<Pair>> entry : map.entrySet()) {
                Set<Pair> island = entry.getValue();
                if (island.contains(newPair)) {
                    return entry.getKey().intValue();
                }
            }
        }

        return -1;
    }
}