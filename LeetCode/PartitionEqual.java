import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int x : nums) {
            // early exit if x > target (safe to skip), but we still need others
            for (int s = target; s >= x; s--) {
                dp[s] = dp[s] || dp[s - x];
            }
            if (dp[target]) return true; // optional early stop
        }
        return dp[target];
    }
}
