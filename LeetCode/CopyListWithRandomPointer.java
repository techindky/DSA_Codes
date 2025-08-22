class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: interleave cloned nodes
        Node cur = head;
        while (cur != null) {
            Node nxt = cur.next;
            Node clone = new Node(cur.val);
            cur.next = clone;
            clone.next = nxt;
            cur = nxt;
        }

        // Step 2: set random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Step 3: detach the copy and restore original
        Node dummy = new Node(0);
        Node copyTail = dummy;
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            cur.next = clone.next;   // restore original
            copyTail.next = clone;   // append clone
            copyTail = clone;
            cur = cur.next;
        }

        return dummy.next;
    }
}
