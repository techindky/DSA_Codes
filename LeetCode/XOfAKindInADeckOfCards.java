class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : deck) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int g = freq.get(deck[0]);
        for (int i : freq.values()) {
            g = gcd(g, i);
        }
        return g > 1;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
