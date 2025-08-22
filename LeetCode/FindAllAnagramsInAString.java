import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> res = new ArrayList<>();
        if (n > m) return res;

        int[] need = new int[26];
        int[] have = new int;
        for (char c : p.toCharArray()) need[c - 'a']++;

        // initialize first window
        for (int i = 0; i < n; i++) have[s.charAt(i) - 'a']++;
        if (Arrays.equals(need, have)) res.add(0);

        for (int i = n; i < m; i++) {
            have[s.charAt(i) - 'a']++;           // add right
            have[s.charAt(i - n) - 'a']--;       // remove left
            if (Arrays.equals(need, have)) {
                res.add(i - n + 1);
            }
        }
        return res;
    }
}
