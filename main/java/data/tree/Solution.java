package data.tree;

import java.util.Stack;

// leecode 230 二叉搜索树中第K小的元素
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            // 遍历到最左边的节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            // 弹出栈顶节点（当前最小的）
            cur = stack.pop();
            n++;
            if (n == k) {
                return cur.val;
            }
            
            // 转向右子树
            cur = cur.right;
        }
        
        return -1; // 如果k超出范围，返回-1
    }
}
