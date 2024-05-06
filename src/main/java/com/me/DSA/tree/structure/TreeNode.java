package com.me.DSA.tree.structure;


import lombok.*;
@NoArgsConstructor
@Data
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return this.val.compareTo(o.val);
    }
}
