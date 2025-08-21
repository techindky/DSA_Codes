import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        // Sort by end coordinate; use long compare to avoid overflow
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b) return Integer.compare(a, b);
            return Long.compare((long)a, (long)b);
        });

        int arrows = 1;
        long arrowPos = points; // place arrow at the end of the first balloon

        for (int i = 1; i < points.length; i++) {
            // If current balloon starts after arrow position, need a new arrow
            if (points[i] > arrowPos) {
                arrows++;
                arrowPos = points[i];
            }
            // else, the current arrow at arrowPos bursts this balloon as well
        }
        return arrows;
    }
}
