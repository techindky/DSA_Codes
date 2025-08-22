class Solution {
    public int numSquares(int n) {
        if (isSquare(n)) return 1;

        int m = n;
        while ((m & 3) == 0) m >>= 2; // divide by 4
        if ((m & 7) == 7) return 4;   // n % 8 == 7 after removing 4^a

        int r = (int)Math.sqrt(n);
        for (int a = 1; a <= r; a++) {
            int b2 = n - a * a;
            int b = (int)Math.sqrt(b2);
            if (b * b == b2) return 2;
        }
        return 3;
    }

    private boolean isSquare(int x) {
        int r = (int)Math.sqrt(x);
        return r * r == x;
    }
}
