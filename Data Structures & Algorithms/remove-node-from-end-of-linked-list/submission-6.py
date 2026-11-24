# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        slow = dummy
        length = 0
        curr = head

        while curr is not None:
            length += 1
            curr = curr.next

        steps = length - n

        for _ in range(steps):
            slow = slow.next
    
        slow.next = slow.next.next

        return dummy.next