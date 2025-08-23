public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        for (int c : citations) {
            if (c >= n) freq[n]++;
            else freq[c]++;
        }
        int cum = 0;
        for (int h = n; h >= 0; h--) {
            cum += freq[h];
            if (cum >= h) return h;
        }
        return 0;
    }
}
