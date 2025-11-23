package data.tree;

// leecode 101  判断对称二叉树
class leecode101 {
    public boolean isSymmetric(TreeNode root) {
        // 对称的判断是：左子树是否和右子树镜像
        return isMirror(root.left, root.right);
    }

    // 判断两个树是否互为镜像
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // 情况1：两个都空 -> 对称
        if (t1 == null && t2 == null)  return true;

        // 情况2：一个空一个不空 -> 不对称
        if (t1 ==null || t2 == null) return false;

        // 情况3：两个都不空 -> 值必须相等，且左右子树必须镜像
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}