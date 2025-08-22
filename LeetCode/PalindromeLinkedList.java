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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1) Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Odd length: skip middle
        if (fast != null) slow = slow.next;

        // 2) Reverse second half
        ListNode second = reverse(slow);

        // 3) Compare
        ListNode p1 = head, p2 = second;
        boolean ok = true;
        while (p2 != null) {
            if (p1.val != p2.val) { ok = false; break; }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4) (Optional) Restore
        reverse(second);

        return ok;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
