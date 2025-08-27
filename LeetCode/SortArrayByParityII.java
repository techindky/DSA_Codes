class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        // int evenIndex = 0, oddIndex = 1;
        // int[] res = new int[nums.length];
        // for (int i : nums) {
        //     if (i % 2 == 0) {
        //         res[evenIndex] = i;
        //         evenIndex += 2;
        //     } else {
        //         res[oddIndex] = i;
        //         oddIndex += 2;
        //     }
        // }
        // return res;
        int even = 0, odd = 1, n = nums.length;
        while (even < n && odd < n) {
            if (nums[even] % 2 != 0 && nums[odd] % 2 == 0) {
                int t = nums[even];
                nums[even] = nums[odd];
                nums[odd] = t;
                even += 2;
                odd += 2;
            } else if (nums[even] % 2 != 0) {
                odd += 2;
            } else if (nums[odd] % 2 == 0) {
                even += 2;
            } else {
                odd += 2;
                even += 2;
            }
        }
        return nums;
    }
}
