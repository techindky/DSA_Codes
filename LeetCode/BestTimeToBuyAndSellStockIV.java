class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // Case 1: effectively unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        // Case 2: DP with O(n) space
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                curr[i] = Math.max(curr[i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[i] - prices[i]);
            }
            // roll arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n - 1];
    }
}
