import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) buckets[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int f = nums.length; f >= 1 && idx < k; f--) {
            for (int v : buckets[f]) {
                res[idx++] = v;
                if (idx == k) break;
            }
        }
        return res;
    }
}
