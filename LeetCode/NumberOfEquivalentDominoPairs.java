class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        int res = 0;
        for (int[] d : dominoes) {
            int key = d[0] > d[1] ? 10 * d[1] + d[0] : 10 * d[0] + d[1];
            res += freq[key];
            freq[key]++;
        }
        return res;
    }
}

/**
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
       Map<Integer, Integer> freq = new HashMap<>();
       int res = 0;
       for (int[] d : dominoes) {
        int key = 0;
        if (d[0] > d[1]) {
            key += 10 * d[1];
            key += d[0];
        } else {
            key += 10 * d[0];
            key += d[1];
        }
        int value = freq.getOrDefault(key,0);
        freq.put(key, value + 1);
        if (value + 1 > 1) res += value;
       }
       return res;
    }
}
 */
