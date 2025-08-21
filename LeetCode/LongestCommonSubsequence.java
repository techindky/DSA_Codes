class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // Ensure n is the smaller dimension for memory locality (optional)
        if (n > m) { // swap to keep second dimension smaller if desired
            String tmpS = text1; text1 = text2; text2 = tmpS;
            int tmp = m; m = n; n = tmp;
        }
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = text2.charAt(j - 1);
                if (a == b) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // swap rows
            int[] tmp = prev; prev = curr; curr = tmp;
        }
        return prev[n];
    }
}
