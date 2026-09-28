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
    public ListNode reverseList(ListNode head) {
        // brute
        // it only uses head and next and val
        // always write base case
        if(head == null){
            return null;
        }

        Stack<ListNode> s = new Stack<>();
        ListNode curr = head;

        // push all node inside stack
        while(curr != null){
            s.push(curr);
            curr = curr.next;
        }

        // so now head become the last element that went inside as its lifo
        ListNode newHead = s.pop();
        curr = newHead;

        while(!s.isEmpty()){
        ListNode node = s.pop();
        curr.next = node;
        curr = curr.next;
        }
        // now move the last node to point at null
        curr.next = null;

        return newHead;
    }
}
