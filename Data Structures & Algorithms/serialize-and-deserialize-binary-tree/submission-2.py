# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if root is None:
            return "N"

        q = deque()
        q.append(root)
        res = []

        while q:
            size = len(q)
            curr = q.popleft()
            if curr is None:
                res.append("N")
                continue
            res.append(str(curr.val))
            q.append(curr.left)
            q.append(curr.right)

        return ",".join(res)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        value = data.split(",")

        if value[0] == "N":
            return None
        
        root = TreeNode(int(value[0]))
        q = deque()
        q.append(root)
        idx = 1

        while q:
            curr = q.popleft()
            # now next token is this parents child
            if value[idx] != "N":
                curr.left = TreeNode(int(value[idx]))
                q.append(curr.left)
            idx += 1
            # next token is parent right child
            if value[idx] != "N":
                curr.right = TreeNode(int(value[idx]))
                q.append(curr.right)
            idx += 1
        return root
