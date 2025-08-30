class Solution {
    public int score(String[] cards, char x) {
        int nD = 0;
        int[] left = new int[11];
        int[] right = new int[11];
        for (String s : cards) {
            char a = s.charAt(0), b = s.charAt(1);
            if (a == x && b == x) {
                nD++;
            } else if (a == x && b != x) {
                left[b - 'a']++;
            } else if (b == x && a != x) {
                right[a - 'a']++;
            }
        }
        int nL = 0, nR = 0;
        for (int c : left)
            nL += c;
        for (int c : right)
            nR += c;
        int T = nL + nR;
        int ML = maxPairsAcrossGroups(left);
        int MR = maxPairsAcrossGroups(right);
        int Mmax = ML + MR;
        if (nD >= T)
            return T;
        return nD + Math.min(Mmax, (T - nD) / 2);
    }

    private int maxPairsAcrossGroups(int[] counts) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : counts)
            if (c > 0)
                pq.add(c);
        int pairs = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            a--;
            b--;
            pairs++;
            if (a > 0)
                pq.add(a);
            if (b > 0)
                pq.add(b);
        }
        return pairs;
    }
}©leetcode
