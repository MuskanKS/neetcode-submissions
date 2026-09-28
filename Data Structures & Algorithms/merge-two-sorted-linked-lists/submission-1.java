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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // brute
        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = list1;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        curr = list2;

        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(arr);

        ListNode dummy = new ListNode(-1);
        ListNode currNew = dummy;
        for(int res : arr){
            currNew.next = new ListNode(res);
            currNew = currNew.next;
        }
        return dummy.next;
    }
}