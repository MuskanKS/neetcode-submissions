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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // better
        ListNode curr = head;
        ArrayList<ListNode> arr = new ArrayList<>();


        while(curr != null){
            arr.add(curr);
            curr = curr.next;
        }
        int idx = arr.size() - n;

        if(idx == 0){
            return head.next;
        }
        //skip target node
        arr.get(idx - 1).next = arr.get(idx).next;
        return head;
    }
}
