class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];
            long take = points;
            if (i + skip + 1 < n) {
                take += dp[i + skip + 1];
            }
            dp[i] = Math.max(take, dp[i + 1]);
        }

        return dp[0];
    }
}
