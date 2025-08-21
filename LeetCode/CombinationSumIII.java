import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), 0, res);
        return res;
    }

    private void backtrack(int start, int k, int target, List<Integer> path, int sum, List<List<Integer>> res) {
        // If k numbers chosen
        if (path.size() == k) {
            if (sum == target) res.add(new ArrayList<>(path));
            return;
        }
        // Prune: if even picking the smallest remaining numbers would exceed target
        // or picking the largest remaining numbers would still be less than target.
        int remaining = k - path.size();
        // minimal possible sum using next 'remaining' numbers: start + (start+1) + ... + (start+remaining-1)
        int minPossible = remaining * (2 * start + (remaining - 1)) / 2;
        // maximal possible sum using largest 'remaining' numbers from 9 downwards: 9 + 8 + ... + (10-remaining)
        int maxStart = 9;
        int maxPossible = remaining * (2 * maxStart - (remaining - 1)) / 2;
        if (sum + minPossible > target) return;
        if (sum + maxPossible < target) return;

        for (int num = start; num <= 9; num++) {
            // More pruning: if sum would exceed target, break (numbers increase)
            if (sum + num > target) break;

            path.add(num);
            backtrack(num + 1, k, target, path, sum + num, res);
            path.remove(path.size() - 1);
        }
    }
}
