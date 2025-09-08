class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            int num = 1;
            for (int i = 0; i < n; i+=2) {
                res[i] = -num;
                res[i+1] = num++;
            }
        } else {
            int num = 1;
            for (int i = 1; i < n; i+=2) {
                res[i] = -num;
                res[i+1] = num++;
            }
        }
        return res;
    }
}
