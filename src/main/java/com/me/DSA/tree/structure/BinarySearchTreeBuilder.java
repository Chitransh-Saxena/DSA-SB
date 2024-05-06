package com.me.DSA.tree.structure;

import com.me.DSA.tree.structure.Tree;
import com.me.DSA.tree.structure.impl.BinarySearchTreeImpl;

public interface BinarySearchTreeBuilder<T extends Comparable<T>> {

    BinarySearchTreeImpl<T> buildBSTFromPreorder(T[] preorder);
}
