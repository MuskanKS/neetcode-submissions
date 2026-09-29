/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // example we will choose from the lists and see the smallest amongst all 0th index and get to choose one
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode curr : lists){
            if(curr != null){
                pq.add(curr);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();

            curr.next = temp;
            curr = curr.next;

            if(temp.next != null){
                pq.add(temp.next);
            }

        }
        return dummy.next;
    }
}
