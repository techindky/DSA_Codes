import java.util.*;
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            int f = freq.getOrDefault(i, 0);
            freq.put(i, f + 1);
            if (f + 1 == n) return i;
        }
        return -1;
    }
}
