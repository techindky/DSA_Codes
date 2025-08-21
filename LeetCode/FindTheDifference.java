class Solution {
    public char findTheDifference(String s, String t) {
        /* Approach 1: Simple Programming
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) return char2[i];
        }
        return char2[char2.length - 1]; */

        /// Bit Manipulation
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }
        return (char) ans;
    }
}
