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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        helper1(root, sb);

        return sb.toString();
    }
    private void helper1(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");

        helper1(root.left, sb);
        helper1(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        int[] idx = {0};
        return helper2(val, idx);
    }
    private TreeNode helper2(String[] val, int[] idx){
        if(val[idx[0]].equals("N")){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val[idx[0]]));

        idx[0]++;

        root.left = helper2(val, idx);
        root.right = helper2(val, idx);

        return root;
    }
}
