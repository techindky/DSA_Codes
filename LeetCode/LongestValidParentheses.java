class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, ans = 0;
        // Left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++; else right++;
            if (left == right) ans = Math.max(ans, 2 * right);
            else if (right > left) left = right = 0;
        }
        // Right to left
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++; else right++;
            if (left == right) ans = Math.max(ans, 2 * left);
            else if (left > right) left = right = 0;
        }
        return ans;
    }
}

/* Approach 2 : DP
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), ans = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int j = i - dp[i - 1] - 1;
                    if (j >= 0 && s.charAt(j) == '(') {
                        dp[i] = dp[i - 1] + 2 + (j >= 1 ? dp[j - 1] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
*/
