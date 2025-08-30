class Solution {
    private static final int MOD = 1000000007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0)
                    continue;
                int[] nextRight = reflect(i, j + 1, 0, grid);
                if (nextRight != null) {
                    dp[nextRight[0]][nextRight[1]] = (dp[nextRight[0]][nextRight[1]] + dp[i][j]) % MOD;
                }
                int[] nextDown = reflect(i + 1, j, 1, grid);
                if (nextDown != null) {
                    dp[nextDown[0]][nextDown[1]] = (dp[nextDown[0]][nextDown[1]] + dp[i][j]) % MOD;
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }

    private int[] reflect(int x, int y, int dir, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        while (true) {
            if (x < 0 || x >= m || y < 0 || y >= n)
                return null;
            if (grid[x][y] == 0)
                return new int[] { x, y };
            if (dir == 0) {
                x++;
                dir = 1;
            } else {
                y++;
                dir = 0;
            }
        }
    }
}©leetcode
