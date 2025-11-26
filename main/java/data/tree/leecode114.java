package data.tree;

// leecode 114 二叉树展开为链表
class leecode114 {
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    // flatten the root tree and return the list tail
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        // 连接左子树和右子树
        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        // 返回最后一个节点：右尾节点 -> 左尾节点 -> 根节点
        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        } else {
            return root;
        }
    }
}