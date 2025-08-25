class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        ArrayList<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = obstacles[i];
            int idx = upperBound(tails, x); // bisect_right equivalent

            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
            ans[i] = idx + 1;
        }
        return ans;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
