class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        int diff = Math.abs(left - right);

        if (diff > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}