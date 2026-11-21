# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        self.helper(root)

        return self.diameter
        
    def helper(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
            # hum idhar height calculate karenge aur has step pe diameter ke liye left + right karenge

        left = self.helper(root.left)
        right = self.helper(root.right)

        self.diameter = max(self.diameter, left + right)

        return 1 + max(left, right)
