package com.me.DSA.tree.structure.impl;

import com.me.DSA.tree.structure.BinarySearchTreeBuilder;
import com.me.DSA.tree.structure.Tree;
import com.me.DSA.tree.structure.TreeNode;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class BinarySearchTreeBuilderImpl<T extends Comparable<T>> implements BinarySearchTreeBuilder<T> {

    @Override
    public BinarySearchTreeImpl<T> buildBSTFromPreorder(T[] preorder) {

        if(preorder == null || preorder.length == 0)    return null;

        BinarySearchTreeImpl<T> bst = new BinarySearchTreeImpl<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        bst.root = new TreeNode<>(preorder[0]);
        stack.push(bst.root);


        for(int i = 1; i< preorder.length; i++) {

            TreeNode<T> curr = new TreeNode<>(preorder[i]);
            TreeNode<T> prev = stack.peek();

            while(!stack.isEmpty() && preorder[i].compareTo(stack.peek().getVal()) > 0) {

                prev = stack.pop();
            }

            if(preorder[i].compareTo(prev.getVal()) < 0) {
                prev.setLeft(curr);
            }
            else {
                prev.setRight(curr);
            }

            stack.push(curr);
        }


        return bst;
    }
}
