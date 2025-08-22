import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0 || t.length() > s.length()) return "";

        int[] need = new int[128];
        int distinct = 0;
        for (char c : t.toCharArray()) {
            if (need[c] == 0) distinct++;
            need[c]++;
        }

        int[] have = new int;
        int formed = 0;

        int bestLen = Integer.MAX_VALUE, bestL = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            have[rc]++;

            if (need[rc] > 0 && have[rc] == need[rc]) formed++;

            while (formed == distinct) {
                if (r - l + 1 < bestLen) {
                    bestLen = r - l + 1;
                    bestL = l;
                }

                char lc = s.charAt(l);
                have[lc]--;
                if (need[lc] > 0 && have[lc] < need[lc]) formed--;
                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }
}
