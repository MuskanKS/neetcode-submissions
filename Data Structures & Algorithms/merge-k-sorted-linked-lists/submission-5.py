# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        mh = []

        for i, head in enumerate(lists):
            if head is not None:
                heapq.heappush(mh, (head.val, i, head))

        dummy = ListNode(0)
        curr = dummy

        while mh:
            val, i, node = heapq.heappop(mh)
            curr.next = node
            if node.next is not None:
                heapq.heappush(mh, (node.next.val, i, node.next))
            # curr = node or
            curr = curr.next

        return dummy.next
