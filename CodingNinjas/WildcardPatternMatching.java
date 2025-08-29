public class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		int m = pattern.length();
        int n = text.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty pattern matches empty text

        // Initialize first column: pattern vs empty text
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            } else {
                break; // any non-* character cannot match empty string
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = pattern.charAt(i - 1);
                char tChar = text.charAt(j - 1);
                
                if (pChar == tChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
	}
}
