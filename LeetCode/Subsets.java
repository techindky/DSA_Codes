import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // skip
        backtrack(start + 1, nums, cur, res);
        // take
        cur.add(nums[start]);
        backtrack(start + 1, nums, cur, res);
        cur.remove(cur.size() - 1);
    }
}
