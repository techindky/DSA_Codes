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
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // advance fast by n steps
        for (int i = 0; i < n; i++) fast = fast.next;

        // move both until fast at last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete the node after slow
        slow.next = slow.next.next;
        return dummy.next;
    }
}
