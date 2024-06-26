package com.me.DSA.graph;

import com.me.DSA.graph.structures.QuickFind;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickFindTest {


    @Test
    public void testUnionFail() {

        // non-existent nodes should return false with a warning (SOUT)
        // If a union already exists, return false

        int sz1 = 5;
        int[] roots1 = getBasicRootsArray(sz1);
        QuickFind quickFind = new QuickFind(roots1);

        assertFalse(quickFind.union(-1, 6));

        quickFind.union(0, 1);
        assertFalse(quickFind.union(0, 1));
    }

    @Test
    public void testUnionPass() {

        int sz1 = 5;
        int[] roots1 = getBasicRootsArray(sz1);
        QuickFind quickFind = new QuickFind(roots1);



        quickFind.union(0, 1);
        assertTrue(quickFind.connected(0, 1));

        assertFalse(quickFind.connected(0, 2));
    }



    @Test
    public void testUnionPassCustom() {

        int sz1 = 9;
        int[] roots1 = getBasicRootsArray(sz1);
        QuickFind quickFind = new QuickFind(roots1);



        quickFind.union(0, 1);
        quickFind.union(0, 2);
        quickFind.union(1, 3);
        quickFind.union(4, 8);
        quickFind.union(5,6);
        quickFind.union(5, 7);
        assertFalse(quickFind.connected(0, 4));

        quickFind.union(0, 4);

        assertFalse(quickFind.connected(0, 2));
    }

    private int[] getBasicRootsArray(int sz1) {

        int[] roots = new int[sz1];

        for(int i = 0; i<sz1; i++) {
            roots[i] = i;
        }

        return roots;
    }
}
