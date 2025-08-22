class Solution {
    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length; n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || g[i][j] != '1') return;
        g[i][j] = '0'; // mark visited
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}
