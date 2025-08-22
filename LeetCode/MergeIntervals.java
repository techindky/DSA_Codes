import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0].clone();

        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= cur[1]) { // overlap
                cur[1] = Math.max(cur[1], e);
            } else {
                res.add(cur);
                cur = intervals[i].clone();
            }
        }
        res.add(cur);

        return res.toArray(new int[res.size()][]);
    }
}
