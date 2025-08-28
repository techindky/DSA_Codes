class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = nums[0].length(); // length of each number
        int q = queries.length;

        // Precompute sorted indices for every trim length
        int[][] sortedIndices = new int[m + 1][n];
        int[] indices = new int[n];

        // Initially indices = [0, 1, 2, ..., n-1]
        for (int i = 0; i < n; i++) indices[i] = i;

        // For each trim length from 1 to m
        for (int t = 1; t <= m; t++) {
            // Stable sort by digit at position (m - t)
            indices = countingSort(nums, indices, m - t);
            // Save ordering for trim length t
            sortedIndices[t] = indices.clone();
        }

        // Answer queries
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            result[i] = sortedIndices[trim][k - 1];
        }
        return result;
    }

    // Counting sort by digit at given position
    private int[] countingSort(String[] nums, int[] indices, int pos) {
        int n = indices.length;
        int[] count = new int[10]; // digits 0-9
        int[] output = new int[n];

        // Count frequency
        for (int idx : indices) {
            int digit = nums[idx].charAt(pos) - '0';
            count[digit]++;
        }

        // Prefix sums
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output (stable sort, traverse from right to left)
        for (int i = n - 1; i >= 0; i--) {
            int idx = indices[i];
            int digit = nums[idx].charAt(pos) - '0';
            output[--count[digit]] = idx;
        }
        return output;
    }
}
