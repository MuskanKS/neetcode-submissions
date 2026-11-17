"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        hm = {None: None}
        # har original node ka new copy banana hai
        curr = head
        while curr is not None:
            hm[curr] = Node(curr.val)
            curr = curr.next
        
        curr = head
        while curr is not None:
            copy = hm[curr]
            copy.next = hm[curr.next]
            copy.random = hm[curr.random]
            curr = curr.next
        return hm[head]
