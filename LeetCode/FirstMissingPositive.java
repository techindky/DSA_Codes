class Solution {
    public int firstMissingPositive(int[] nums) {
        // Approach 1 : Using cycle sort
        // int n = nums.length;
        // int i = 0;
        // while (i < n) {
        //     int correctIdx = nums[i] - 1;
        //     if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIdx]) {
        //         int temp = nums[i];
        //         nums[i] = nums[correctIdx];
        //         nums[correctIdx] = temp;
        //     } else {
        //         i++;
        //     }
        // }
        // for (i = 0; i < n; i++) {
        //     if (nums[i] != i + 1) {
        //         return i + 1;
        //     }
        // }
        // return n + 1;
        // Approach 2 : Using HashSet
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i > 0) set.add(i);
        }
        int res = 1;
        while (set.contains(res)) {
            res++;
        }
        return res;
    }
}
