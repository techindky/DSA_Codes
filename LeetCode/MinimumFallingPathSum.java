class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // first row = same as matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = dp[i-1][j];
                if (j > 0) minPrev = Math.min(minPrev, dp[i-1][j-1]);
                if (j < n-1) minPrev = Math.min(minPrev, dp[i-1][j+1]);
                dp[i][j] = matrix[i][j] + minPrev;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }
        return ans;
    }
}
