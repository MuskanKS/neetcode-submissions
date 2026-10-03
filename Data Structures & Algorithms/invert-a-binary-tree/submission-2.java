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
    public TreeNode invertTree(TreeNode root) {
        // brute
        // we will traverse every node and check and swap
        if(root == null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.remove();

            // we will swap
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }
        }
        return root;
    }
}
