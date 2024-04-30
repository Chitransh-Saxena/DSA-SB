package com.me.DSA.graph.structures;

import org.springframework.stereotype.Component;


public abstract class AbstractDisjointSet {

    int[] roots;

    public AbstractDisjointSet(int[] roots) {
        this.roots = roots;
    }

    public abstract boolean union(int x, int y);
    public abstract int find(int child);

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
