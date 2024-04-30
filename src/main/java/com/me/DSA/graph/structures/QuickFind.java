package com.me.DSA.graph.structures;

public class QuickFind extends AbstractDisjointSet{


    public QuickFind(int[] roots) {
        super(roots);
    }

    @Override
    public boolean union(int x, int y) {

        if(validateNode(x) || validateNode(y))    return false;

        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)  return false;

        for(int i = 0; i<super.roots.length; i++) {
            if(find(i) == rootY) {
                super.roots[i] = rootX;
            }
        }

        return true;

    }

    @Override
    public int find(int child) {

        if(validateNode(child)) return -1;

        return super.roots[child];
    }

    private boolean validateNode(int node) {
        return node < 0 || node >= super.roots.length;
    }
}
