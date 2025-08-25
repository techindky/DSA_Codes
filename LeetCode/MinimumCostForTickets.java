class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        boolean[] travel = new boolean[n + 1];
        for (int d : days) travel[d] = true;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(
                    dp[i - 1] + costs[0],
                    Math.min(
                        dp[Math.max(0, i - 7)] + costs[1],
                        dp[Math.max(0, i - 30)] + costs[2]
                    )
                );
            }
        }
        return dp[n];
    }
}
