# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        return self.helper(root, k)

    
    def helper(self, root, k) -> int:
        if root is None:
            return None

        ans = self.helper(root.left, k)
        if ans is not None:
            return ans

        self.count += 1
        if self.count == k:
            return root.val

        return self.helper(root.right, k)

