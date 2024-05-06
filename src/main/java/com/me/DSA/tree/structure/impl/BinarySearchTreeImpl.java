package com.me.DSA.tree.structure.impl;

import com.me.DSA.tree.structure.Tree;
import com.me.DSA.tree.structure.TreeNode;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class BinarySearchTreeImpl<T extends Comparable<T>> implements Tree<T> {

    protected TreeNode<T> root;

    @Override
    public void insert(T data) {

    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void traverse() {

    }
}
