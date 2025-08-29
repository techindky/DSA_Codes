class Solution {
    /**
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) res++;
        }
        return res;
    }*/

    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int i : heights) count[i]++;
        int res = 0, expected = 1;
        for (int h : heights) {
            while (expected <= 100 && count[expected] == 0) {
                expected++;
            }
            if (expected != h) {
                res++;
            }
            count[expected]--;
        }
        return res;
    }
}
