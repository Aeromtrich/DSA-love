package data.tree;

import java.util.*;

public class LevelOrderTraversal {

    // 二叉树节点定义
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 层序遍历方法
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的size
            List<Integer> level = new ArrayList<>();
            // 处理当前层的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
            }
            // 当前层加入result
            result.add(level);
        }
        return result;
    }

    // main方法测试
    public static void main(String[] args) {
        /*
                构建二叉树:
                       1
                      / \
                     2   3
                    / \   \
                   4   5   6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> res = levelOrder(root);
        System.out.println("层序遍历结果: " + res);
    }
}