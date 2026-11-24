# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        newHead = slow.next
        slow.next = None
        curr = newHead
        prev = None

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        newHead = prev
        currHead = head

        while newHead is not None:
            curr_next = currHead.next
            new_next = newHead.next

            currHead.next = newHead
            newHead.next = curr_next

            currHead = curr_next
            newHead = new_next
        