import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(); // indices of increasing heights
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int cur = (i < n) ? heights[i] : 0; // sentinel to flush
            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                maxArea = maxArea < h * width ? h * width : maxArea;
            }
            stack.push(i);
        }
        return maxArea;
    }
}
