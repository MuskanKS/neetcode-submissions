# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # sabse pehle kaha rukega
        return self.helper(root) != -1

    def helper(self, root: Optional[TreeNode]) -> bool: 
        if root is None:
            return 0
        
        left = self.helper(root.left)
        right = self.helper(root.right)

        if left == -1 or right == -1:
            return -1
            # means koi bhi bacha agar -1 ho chuka h to niche mat jao minus karne direct parent pe -1 karo tabhi wo root tak sahi propogate karega warna agar l = -1 r = -1 hua to wo to 0 ho jaega so galat na 

        if abs(left - right) > 1:
            return -1

        return 1 + max(left, right)

        