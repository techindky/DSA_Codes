class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            int s = 0;
            int e = row.length - 1;
            int ans = -1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (row[mid] < 0) {
                    ans = mid;
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            if (ans > -1) count += (row.length - ans);
        }
        return count;
    }
}
