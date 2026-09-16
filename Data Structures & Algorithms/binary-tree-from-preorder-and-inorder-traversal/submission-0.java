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
    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inOrderIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootValue = preorder[preOrderIndex++];

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = helper(preorder, inOrderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
