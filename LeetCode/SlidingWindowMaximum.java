import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // indices, values decreasing

        for (int i = 0; i < n; i++) {
            // maintain decreasing deque: drop smaller from back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            // remove out-of-window from front
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // record max for window ending at i
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
