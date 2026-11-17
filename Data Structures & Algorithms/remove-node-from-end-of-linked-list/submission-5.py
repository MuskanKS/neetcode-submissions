# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head

        length = 0
        curr = head
        while curr is not None:
            length += 1
            curr = curr.next
         
        # we will go delete hone wale node ke pehle tak 
        steps = length - n
        prev = dummy

        for _ in range(steps):
            prev = prev.next
        prev.next = prev.next.next
        return dummy.next