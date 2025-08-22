class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Approach 1 : Brute-Force
        // int n = s.length();
        // int mid = n / 2;
        // for (int i = 1; i <= mid; i++) {
        //     String subString = s.substring(0, i);
        //     int j = i;
        //     boolean isValid = true;
        //     while (j <= n-i) {
        //         if (!s.substring(j,j+i).equals(subString)) {
        //             isValid = false;
        //             break;
        //         }
        //         j += i;
        //     }
        //     if (j < n && !s.substring(j).equals(subString)) {
        //         isValid = false;
        //     }
        //     if (isValid) return true;
        // }
        // return false;
        // Approach 2 : Concatenation
        // String t = (s + s).substring(1, 2 * s.length() - 1);
        // return t.contains(s);

        // Approach 3 : KMP - algorithm
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
            if (s.charAt(i) == s.charAt(j)) lps[i] = ++j;
        }
        int L = lps[n - 1];
        return L > 0 && n % (n - L) == 0;
    }
}
