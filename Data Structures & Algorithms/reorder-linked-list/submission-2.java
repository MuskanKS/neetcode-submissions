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
        // brute
        // store all the nodes
        ListNode curr = head;
        ArrayList<ListNode> arr = new ArrayList<>();

        while(curr != null){
            arr.add(curr);
            curr = curr.next;
        }
        int left = 0;
        int right = arr.size() - 1;

        while(left < right){
            arr.get(left).next = arr.get(right);
            left++;

            arr.get(right).next = arr.get(left);
            right--;
        }
        // basicaly when the loop end left == right means both are same node so write left or right doesnt matter;
        arr.get(left).next = null;

    }
}
