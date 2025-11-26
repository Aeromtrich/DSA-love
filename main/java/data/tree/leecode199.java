package data.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// leecode 199 二叉树的右视图
class leecode199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode rightSide = null;
            int qLen = q.size();

            // 遍历的是队列长度  eg： 2 3 3覆盖了2
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    rightSide = node; // 保存最右边的节点
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }
            // 将最右边的节点加入结果
            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }
        return res;
    }
}