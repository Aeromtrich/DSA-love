package data.tree;

// leecode 98 验证二叉搜索树
class Leecode98 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean valid(TreeNode node, long leftBound, long rightBound) {
        // 空节点是有效的BST
        if (node == null) {
            return true;
        }
        
        // 检查当前节点值是否在允许的范围内
        // 注意：BST要求左子树所有节点 < 当前节点 < 右子树所有节点
        if (!(node.val > leftBound && node.val < rightBound)) {
            return false;
        }
        
        // 递归检查左子树和右子树
        // 左子树：上限变为当前节点值
        // 右子树：下限变为当前节点值
        return valid(node.left, leftBound, node.val) && 
               valid(node.right, node.val, rightBound);
    }
}