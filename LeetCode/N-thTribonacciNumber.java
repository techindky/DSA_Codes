class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int a = 0, b = 1, c = 1; // T0, T1, T2
        for (int i = 3; i <= n; i++) {
            int d = a + b + c; // T_i
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
