class Solution {
    public void reorderList(ListNode head) {

        // 1. Find middle
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split into two lists
        ListNode secList = slow.next;
        slow.next = null;

        // 3. Reverse second list
        ListNode prev = null;
        ListNode curr = secList;

        while (curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        secList = prev;

        // 4. Merge alternately
        ListNode firstList = head;

        while (secList != null) {

            // Save next nodes before changing links
            ListNode firstNext = firstList.next;
            ListNode secNext = secList.next;

            // First → Second → Next First
            firstList.next = secList;
            secList.next = firstNext;

            // Move forward
            firstList = firstNext;
            secList = secNext;
        }
    }
}