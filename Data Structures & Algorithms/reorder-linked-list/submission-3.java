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
    public void reorderList(ListNode head) {
        // now we will solve using deque
        Deque<ListNode> dq = new ArrayDeque<>();

        ListNode curr = head;

        while(curr != null){
            dq.addLast(curr);
            curr = curr.next;
            // so it will look like 2, 4, 6, 8
        }

        // now lets start our operation
        curr = dq.removeFirst();
        // remove first as it said 0 has to be the first then the tigdam will start
        while(!dq.isEmpty()){
            // take last
            ListNode last = dq.removeLast();
            curr.next = last;
            curr = curr.next;
            if(!dq.isEmpty()){
                ListNode first = dq.removeFirst();
                curr.next = first;
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}
