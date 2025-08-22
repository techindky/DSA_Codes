import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int maxLen = 0;
        for (String w : set) maxLen = Math.max(maxLen, w.length());

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // only consider lengths up to maxLen
            for (int l = 1; l <= Math.min(maxLen, i); l++) {
                if (!dp[i - l]) continue;
                if (set.contains(s.substring(i - l, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
