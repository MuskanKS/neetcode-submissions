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

        int n = 0; // count no of nodes
        ListNode curr = head;

        while(curr != null){
            n++;
            curr = curr.next;
        }

        // we got total no of nodes
        // store value in res
        int[] res = new int[n];
        curr = head;

        int i = 0;

        while(curr != null){
            res[i] = curr.val;
            i++;
            curr = curr.next;
        }
        // create reversed ll
        ListNode newHead = null;
        for(int j = 0; j < n; j++){
            ListNode node = new ListNode(res[j]);

            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}
