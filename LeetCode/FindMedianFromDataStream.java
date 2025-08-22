import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> low;  // max-heap
    private PriorityQueue<Integer> high; // min-heap

    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: add to low (max-heap)
        low.offer(num);
        // Step 2: ensure ordering: max(low) <= min(high)
        if (!high.isEmpty() && low.peek() > high.peek()) {
            high.offer(low.poll());
        }
        // Step 3: rebalance sizes
        if (low.size() > high.size() + 1) {
            high.offer(low.poll());
        } else if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() > high.size()) return (double) low.peek();
        return (low.peek() + high.peek()) / 2.0;
    }
}
