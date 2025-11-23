package data.tree;

class leecode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        // 区间无效时返回 null
        if (left > right) return null;

        // 取中间节点作为根
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 左右子树递归构建
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }
}