class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length, idx = k;
        int[] temp = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[idx % (m * n)] = grid[i][j];
                idx++;
            }
        }
        for (int i = 0; i < m * n; i += n) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(temp[i+j]);
            }
            res.add(row);
        }
        return res;
    }
}
