class Solution {
    public int uniquePaths(int m, int n) {
        int r = Math.min(m - 1, n - 1); // choose smaller to minimize iterations
        long res = 1;
        // Compute C(m+n-2, r) = product_{i=1..r} (m+n-2 - r + i) / i
        for (int i = 1; i <= r; i++) {
            res = res * (m + n - 2 - r + i) / i;
        }
        return (int) res;
    }
}
