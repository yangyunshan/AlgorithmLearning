package com.yys.tree;

/**
 * 树节点
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}
