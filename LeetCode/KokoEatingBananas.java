import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);

        int lo = 1, hi = max, ans = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                hi = mid - 1; // try smaller k
            } else {
                lo = mid + 1; // need larger k
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            // ceil(p / k) without floating point
            hours += (p + k - 1) / k;
            if (hours > h) return false; // early stop
        }
        return hours <= h;
    }
}
