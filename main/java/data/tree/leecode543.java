package data.tree;

// leecode 543 求二叉树的直径
class leecode543 {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    // 返回当前节点的最大深度
    private int depth(TreeNode node) {
        if (node == null) return 0;
        // 左子树最大深度 // 右子树最大深度
        int left = depth(node.left);
        int right = depth(node.right);
        // 更新最大直径：左深度 + 右深度
        diameter = Math.max(diameter, left + right);
        // 当前节点的深度 = 1 + max(左深度,右深度)
        return 1 + Math.max(left, right);
    }
}