class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        int[] basket = new int[]{-1,-1};
        int[] cnt = new int[2];
        int lastRun = 0;
        for (int i : fruits) {
            if (i == basket[1]) {
                cnt[1]++;
                lastRun++;
            } else if (i == basket[0]) {
                int temp = basket[0];
                basket[0] = basket[1];
                basket[1] = temp;
                temp = cnt[0];
                cnt[0] = cnt[1];
                cnt[1] = temp;
                cnt[1]++;
                lastRun = 1;
            } else {
                basket[0] = basket[1];
                basket[1] = i;
                cnt[0] = lastRun;
                lastRun = 1;
                cnt[1] = 1;
            }
            ans = Math.max(ans, cnt[0] + cnt[1]);
        }
        return ans;
    }
}
