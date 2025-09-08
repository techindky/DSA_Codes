class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1, b = n - 1;
        while (true) {
            if (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")) {
                a++;
                b--;
            } else break;
        }
        return new int[]{a,b};
    }
}
