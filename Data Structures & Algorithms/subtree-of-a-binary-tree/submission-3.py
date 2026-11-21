# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # idhar it will stop when root is null
        if subRoot is None:
            return True
        if root is None:
            return False

        if self.helper(root, subRoot):
            return True

        leftRoot = self.isSubtree(root.left, subRoot)
        rightRoot = self.isSubtree(root.right, subRoot)

        return leftRoot or rightRoot

    def helper(self, r: Optional[TreeNode], sR: Optional[TreeNode]) -> bool:
        if r is None and sR is None:
            return True
        
        if r is None or sR is None:
            return False

        if r.val != sR.val:
            return False
        
        left = self.helper(r.left, sR.left)
        right = self.helper(r.right, sR.right)
        return left and right
        