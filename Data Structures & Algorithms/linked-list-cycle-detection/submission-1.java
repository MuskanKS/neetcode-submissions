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
    public boolean hasCycle(ListNode head) {
        // brute
        // using hashset
        HashSet<ListNode> hs = new HashSet<>();
        ListNode curr = head;

        while(curr != null){
            if(hs.contains(curr)){
                return true;
            }
            // means if its a cycle it will never be curr = null 
            hs.add(curr);
            curr = curr.next;
        }
        return false;

    }
}
