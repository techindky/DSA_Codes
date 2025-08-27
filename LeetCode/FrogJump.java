import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        
        dp.get(0).add(0); // starting jump length is 0
        
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0 && dp.containsKey(stone + step)) {
                        dp.get(stone + step).add(step);
                    }
                }
            }
        }
        
        return !dp.get(stones[n - 1]).isEmpty();
    }
}
