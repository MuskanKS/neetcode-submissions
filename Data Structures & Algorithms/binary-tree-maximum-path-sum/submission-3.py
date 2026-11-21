# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.best = float("-inf")
        self.helper(root)
        return self.best
        
    def helper(self, root) -> int:
        if root is None:
            return 0
        
        left_gain = max(0, self.helper(root.left))
        right_gain = max(0, self.helper(root.right))

        with_root = root.val + left_gain + right_gain
        self.best = max(self.best, with_root)

        return root.val + max(left_gain, right_gain)

