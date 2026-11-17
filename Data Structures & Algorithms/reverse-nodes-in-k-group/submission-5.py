# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        group_prev = dummy

        while True:
            kth = group_prev
            for _ in range(k):
                kth = kth.next
                if kth is None:
                    return dummy.next
            group_next = kth.next

            prev = group_next
            curr = group_prev.next

            while curr is not group_next:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            old_group_head = group_prev.next
            group_prev.next = kth
            group_prev = old_group_head