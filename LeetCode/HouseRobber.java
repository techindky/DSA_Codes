class Solution {
    public int rob(int[] nums) {
        int take = 0; // rob current
        int skip = 0; // skip current

        for (int x : nums) {
            int newTake = skip + x;
            int newSkip = Math.max(take, skip);
            take = newTake;
            skip = newSkip;
        }
        return Math.max(take, skip);
    }
}
