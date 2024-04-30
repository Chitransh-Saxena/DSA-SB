package com.me.DSA.graph.structures;

public class QuickUnion extends AbstractDisjointSet{

    public QuickUnion(int[] roots) {
        super(roots);
    }

    @Override
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false; // x and y are already in the same set
        }
        roots[rootX] = rootY; // Make root of x point to root of y
        return true;
    }

    @Override
    public int find(int child) {
        while (child != roots[child]) {
            child = roots[child];
        }
        return child; // Return the root of the tree containing child
    }
}
