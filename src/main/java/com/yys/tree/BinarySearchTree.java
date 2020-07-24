package com.yys.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二进制搜索树基础类
 */
public class BinarySearchTree {
    private int size;
    private TreeNode root;

    public BinarySearchTree() {
        size = 0;
        root = null;
    }

    /**
     * 在树中添加节点
     */
    public void add(TreeNode node) {
        //树为空的情况下
        if (root == null) {
            if (node!=null) {
                root = node;
            }
        }

        //树不为空的情况下
        TreeNode curr = root;
        TreeNode currParent = null;
        while (curr!=null) {
            currParent = curr;
            if (node.val<curr.val) {
                curr = curr.left;
            } else if (node.val>curr.val) {
                curr = curr.right;
            } else {
//                curr = node;
                return;
            }
        }
        if (currParent.val>node.val) {
            currParent.left = node;
        } else {
            currParent.right = node;
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public void preorderTraversal(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postorderTraversal(TreeNode root) {
        if (root==null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inorderTraversal(TreeNode root) {
        if (root==null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    /**
     * 层次遍历
     * 利用队列实现
     * @param root
     */
    public void levelTraversal(TreeNode root) {
        if (root==null) {
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            if (curr!=null) {
                System.out.println(curr.val);
                if (curr.left!=null) {
                    nodes.offer(curr.left);
                }
                if (curr.right!=null) {
                    nodes.offer(curr.right);
                }
            }
        }
    }

    /**
     * 层次遍历，按层输出
     * @return
     */
    public List<List<Integer>> test() {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) {
            return result;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i=nodes.size();i>0;i--) {
                TreeNode curr = nodes.poll();
                if(curr!=null) {
                    temp.add(curr.val);
                    if(curr.left!=null)
                        nodes.offer(curr.left);
                    if(curr.right!=null)
                        nodes.offer(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(4);

        binarySearchTree.add(node1);
        binarySearchTree.add(node2);
        binarySearchTree.add(node3);
        binarySearchTree.add(node4);
        binarySearchTree.add(node5);
        binarySearchTree.add(node6);
        binarySearchTree.add(node7);

        binarySearchTree.preorderTraversal(binarySearchTree.root);
        System.out.println("-----------------------------------");
        binarySearchTree.inorderTraversal(binarySearchTree.root);
        System.out.println("-----------------------------------");
        binarySearchTree.postorderTraversal(binarySearchTree.root);
        System.out.println("-----------------------------------");
        binarySearchTree.levelTraversal(binarySearchTree.root);

        List<List<Integer>> ss = binarySearchTree.test();
        System.out.println(ss);
    }
}
