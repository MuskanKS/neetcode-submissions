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
    private ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return arr;
        }
        helper(root.left, arr);
        arr.add(root.val);
        helper(root.right, arr);

        return arr;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = helper(root, new ArrayList<>());
        return nums.get(k - 1);
    }
}
