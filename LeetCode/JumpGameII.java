class Solution {
    public int jump(int[] nums) {
        int l , r, ans;
        l = r = ans = 0;
        int n = nums.length;

        while (r<n-1) {
            int farthest = 0;
            for (int i = l; i <=r; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }

            if(farthest<=r){
                return -1;
            }
      
            l = r+1;
            r = farthest;
            ans ++;
        }
        return ans;
    }
}
