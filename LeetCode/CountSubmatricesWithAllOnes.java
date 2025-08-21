class Solution {
    public int numSubmat(int[][] mat) {
        int[] heights = new int[mat[0].length];
        int res = 0;
        for (int[] row : mat) {
            for (int i = 0; i < heights.length; i++) {
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{-1,0,-1});
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek()[2] >= heights[i]) {
                    stack.pop();
                }
                int j = stack.peek()[0], prev = stack.peek()[1];
                int cur = prev + (i - j) * heights[i];
                stack.push(new int[]{i,cur,heights[i]});
                res += cur;
            }
        }
        return res;
    }
}
