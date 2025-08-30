class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for (char c : s.toCharArray()) if (c == '0') z++;
        if (z == 0) return 0;
        if (k > n) return -1;

        int t0 = (z + k - 1) / k;
        if ((k % 2 == 0) && (z % 2 == 1)) return -1;

        int step = (k % 2 == 1) ? 2 : 1;
        int t = t0;
        if (k % 2 == 1 && (t % 2 != (z % 2))) t++;

        long limit = t0 + 2L * n;
        for (; t <= limit; t += step) {
            long R = 1L * t * k - z;
            if (R < 0) continue;
            if ((R & 1L) != 0) continue;
            long cap = 1L * z * ((t - 1) / 2) + 1L * (n - z) * (t / 2);
            if (cap >= R / 2) return t;
        }
        return -1;
    }
}
©leetcode
