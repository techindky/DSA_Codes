import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // start of a sequence
                int y = x;
                while (set.contains(y)) y++;
                best = Math.max(best, y - x);
            }
        }
        return best;
    }
}
