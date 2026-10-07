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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int idx = left;
        while(inorder[idx] != rootVal){
            idx++;
        }
        root.left = helper(preorder, inorder, left, idx - 1);
        root.right = helper(preorder, inorder, idx + 1, right);

        return root;
    }
}
