class Solution {
    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long f0 = 1, f1 = 1, f2 = 2; // f[n-3], f[n-2], f[n-1]
        for (int i = 3; i <= n; i++) {
            long fn = (2 * f2 % MOD + f0) % MOD; // f[n] = 2*f[n-1] + f[n-3]
            f0 = f1;
            f1 = f2;
            f2 = fn;
        }
        return (int) f2;
    }
}
