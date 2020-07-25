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

    /**
     * 获取树中某个节点的高度(递归的方式)
     * @param node
     * @return
     */
    public int getHeight(TreeNode node) {
        if (node==null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * 获取树中某个节点的高度(非递归的方式)
     * @param node
     * @return
     */
    public int getHeight2(TreeNode node) {
        if (root==null) {
            return 0;
        }

        int height = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(node);
        while (!nodes.isEmpty()) {
            for (int i=nodes.size();i>0;i--) {
                TreeNode curr = nodes.poll();
                if (curr!=null) {
                    if (curr.left!=null) {
                        nodes.offer(curr.left);
                    }
                    if (curr.right!=null) {
                        nodes.offer(curr.right);
                    }
                }
            }
            height ++;
        }
        return height;
    }

    /**
     * 判断二叉树是否为完全二叉树
     * @return
     */
    public boolean isComplete(TreeNode root) {
        boolean flag = false;

        if (root==null) {
            return false;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            //判断节点是否为叶子节点
            if (flag) {
                if (curr.left!=null || curr.right!=null) {
                    return false;
                }
            }
            if (curr.left!=null) {
                nodes.offer(curr.left);
            } else if(curr.right!=null) {//curr.left==null&&curr.right!=null
                return false;
            }

            if (curr.right!=null){//curr.left!=null&&curr.right!=null
                nodes.offer(curr.right);
            } else {//curr.right==null
                //包括条件：curr.left!=null&&curr.right==null和current.left==null&&curr.right==null
                flag = true;//标记继续遍历的节点都要为叶子节点
            }
        }

        return true;
    }

    /**
     * 反转节点
     * @param root
     * @return
     */
    public TreeNode reverseTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode curr = root;
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        reverseTree(curr.left);
        reverseTree(curr.right);

        return root;
    }

    /**
     * 获取节点的先驱节点(中序遍历的前一个节点)
     * @param node
     * @return
     */
    public TreeNode getPredecessor(TreeNode node) {
        if (node==null) {
            return null;
        }

        TreeNode curr = node;
        if (node.left!=null) {
            while (curr.right!=null) {
                curr = curr.right;
            }
            return curr;
        }
        while (node.parent!=null && node.parent.left==node) {
            curr = curr.parent;
        }
        return curr.parent;
    }

    /**
     * 获取节点的后继节点(中序遍历的后一个节点)
     * @param node
     * @return
     */
    public TreeNode getSuccessor(TreeNode node) {
        if (node==null) {
            return null;
        }

        TreeNode curr = node;
        if (node.right!=null) {
            while (curr.left!=null) {
                curr = curr.left;
            }
            return curr;
        }
        while (node.parent!=null && node.parent.right==node) {
            curr = curr.parent;
        }
        return curr.parent;
    }

    public void remove(TreeNode node) {
        if (node==null) {
            return;
        }

        //删除度为2的节点(为什么要把度为2的处理放在最前面处理？
        //因为删除节点是用后继节点替换的，而后继节点的度都为1或0，后续节点替换掉待删除的节点后，后继节点仍需要删除，
        // 所以后续就又回到了度为1或0节点的删除处理上，所以才会这样设计)
        if (node.left!=null && node.right!=null) {
            //获取node的后继节点，并用后继节点替换掉待删除的节点，最后删除后继节点（注意：前后继节点的度只能为1或0）
            TreeNode temp = getSuccessor(node);
            //此处采用将节点值替换，而不是替换整个节点
            node.val = temp.val;
            node = temp;//此时node的度为1或0，待后续删除
        }

        //删除叶子节点，度为0
        if (node.left==null && node.right==null) {
            if (node.parent==null) {//node为根节点的情况
                root = null;
            }
            else if (node==node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }

        //删除度为1的节点
        TreeNode temp = node.left!=null ? node.left : node.right;
        if (node.left!=null && node.right==null) {
            if (node.parent==null) {
                root = temp;
                temp.parent = root;
            }
            else if (node==node.parent.left) {
                node.parent.left = temp;
                temp.parent = node.parent;
            } else {
                node.parent.right = temp;
                temp.parent = node.parent;
            }
        }

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

//        int height = binarySearchTree.getHeight2(node2);
//        boolean flag = binarySearchTree.isComplete(node1);
        binarySearchTree.preorderTraversal(binarySearchTree.reverseTree(binarySearchTree.root));

//        System.out.println(flag);
    }
}
