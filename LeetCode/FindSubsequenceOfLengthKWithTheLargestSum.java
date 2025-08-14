import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Store value and index
        int[][] valIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            valIndex[i][0] = nums[i]; // value
            valIndex[i][1] = i;       // index
        }

        // Step 2: Sort by value descending
        Arrays.sort(valIndex, (a, b) -> b[0] - a[0]);

        // Step 3: Take top k
        List<int[]> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(valIndex[i]);
        }

        // Step 4: Sort top k by index (to maintain original order)
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Step 5: Build result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
