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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // find kth from groupPrev
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

            ListNode groupNext = kth.next;

            // reverse group
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
            }

            // reattach
            ListNode tail = groupPrev.next; // old head becomes tail
            groupPrev.next = prev;
            groupPrev = tail;
        }

        return dummy.next;
    }
}
