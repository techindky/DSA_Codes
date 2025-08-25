class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            maxLen = Math.max(maxLen, dp.get(num));
        }

        return maxLen;
    }
}
