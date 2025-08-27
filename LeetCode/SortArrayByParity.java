class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // int[] res = new int[nums.length];
        // int evenIndex = 0, oddIndex = nums.length - 1;
        // for (int i : nums) {
        //     if (i % 2 == 0) {
        //         res[evenIndex++] = i;
        //     } else {
        //         res[oddIndex--] = i;
        //     }
        // }
        // return res;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            } else if (nums[left] % 2 != 0) {
                right--;
            } else if (nums[right] % 2 == 0) {
                left++;
            } else {
                right--;
                left++;
            }
        }
        return nums;
    }
}
