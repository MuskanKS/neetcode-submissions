# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preorder = preorder
        self.inorder_index = {value: i for i, value in enumerate(inorder)}
        self.preroot = 0
        return self.helper(0, len(inorder) - 1)

    def helper(self, left: int, right: int) -> Optional[TreeNode]:
        if left > right:
            return None
        
        root_value = self.preorder[self.preroot]
        self.preroot += 1

        root = TreeNode(root_value)
        middle = self.inorder_index[root_value]

        root.left = self.helper(left, middle - 1)
        root.right = self.helper(middle + 1, right)

        return root