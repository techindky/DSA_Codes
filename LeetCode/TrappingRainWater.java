class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int total = 0;
        int peak = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[peak] < height[i]) {
                peak = i;
            }
        }
        int leftMax = 0;
        for (int i = 0; i < peak; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                total += leftMax - height[i];
            }
        }
        int rightMax = 0;
        for (int i = height.length - 1; i > peak; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                total += rightMax - height[i];
            }
        }
        return total;
    }
}
