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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = new ArrayList<>();

        while(l1 != null){
            arr1.add(l1.val);
            l1 = l1.next;
        }

        ArrayList<Integer> arr2 = new ArrayList<>();

        while(l2 != null){
            arr2.add(l2.val);
            l2 = l2.next;
        }
        // addition
        int i = 0;
        int j = 0;
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(i < arr1.size() || j < arr2.size() || carry != 0){
            int x = 0;
            int y = 0;

            if(i < arr1.size()){
                x = arr1.get(i);
            }
            if(j < arr2.size()){
                y = arr2.get(j);
            }

            int sum = x + y + carry;

            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            i++;
            j++;
        }
        return dummy.next;
    }
}
