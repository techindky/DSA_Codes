class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        int[] points = new int[maxVal + 1];
        for (int num : nums) points[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i <= maxVal; i++) {
            int takeNew = skip + points[i];
            skip = Math.max(skip, take);
            take = takeNew;
        }
        return Math.max(take, skip);
    }
}
