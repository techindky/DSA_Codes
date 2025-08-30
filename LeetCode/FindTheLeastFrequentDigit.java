class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] f = new int[10];
        while (n > 0) {
            f[n % 10]++;
            n /= 10;
        }
        int min = Integer.MAX_VALUE, idx = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 0 && min > f[i]) {
                min = f[i];
                idx = i;
            }
        }
        return idx;
    }
}
