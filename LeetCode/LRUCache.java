import java.util.*;

class LRUCache {
    private static class Node {
        int key, val;
        Node prev, next;
        Node() {}
        Node(int k, int v) { key = k; val = v; }
    }

    private final int cap;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(); // MRU side
    private final Node tail = new Node(); // LRU side

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addFront(Node x) {
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void moveToFront(Node x) {
        remove(x);
        addFront(x);
    }

    private Node popLRU() {
        Node lru = tail.prev;
        if (lru == head) return null;
        remove(lru);
        return lru;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToFront(node);
            return;
        }
        Node n = new Node(key, value);
        map.put(key, n);
        addFront(n);

        if (map.size() > cap) {
            Node lru = popLRU();
            if (lru != null) map.remove(lru.key);
        }
    }
}
