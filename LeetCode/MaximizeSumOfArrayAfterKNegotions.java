class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 101, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(nums[i], min);
            sum += nums[i];
        }
        if (min == 0) return sum;
        if (k % 2 == 1) {
            sum -= 2 * min;
        }
        return sum;
    }
}
