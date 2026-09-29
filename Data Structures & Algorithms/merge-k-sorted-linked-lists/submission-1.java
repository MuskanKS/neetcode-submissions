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
        // brute force
        // here we will just put all the values in the list and then will sort it and the make it a ll
        ArrayList<Integer> arr = new ArrayList<>();

        for(ListNode curr : lists){
            while(curr != null){
                arr.add(curr.val);
                curr = curr.next;
            }
        }
        // sort all the values
        Collections.sort(arr);

        // create ll
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int val : arr){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}
