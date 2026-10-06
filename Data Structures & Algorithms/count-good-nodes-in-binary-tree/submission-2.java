/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        
        return helper(root, root.val);
    }
    private int helper(TreeNode root, int maxSoFar){
        int cnt = 0;
        if(root == null){
            return 0;
        }
        if(root.val >= maxSoFar){
            cnt = 1;
        }
        maxSoFar = Math.max(maxSoFar, root.val);

        cnt += helper(root.left, maxSoFar);
        cnt += helper(root.right, maxSoFar);

        return cnt;
    }
}
