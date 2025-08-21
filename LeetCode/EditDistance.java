class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[j] will represent dp[i-1][j] for previous row; curr[j] is dp[i][j]
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) dp[j] = j; // dp[0][j] = j

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            curr = i; // dp[i] = i
            char a = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = word2.charAt(j - 1);
                if (a == b) {
                    curr[j] = dp[j - 1]; // no operation
                } else {
                    int insert = curr[j - 1] + 1;   // insert b
                    int delete = dp[j] + 1;         // delete a
                    int replace = dp[j - 1] + 1;    // replace a->b
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            dp = curr;
        }
        return dp[n];
    }
}
