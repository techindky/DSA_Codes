class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int minEle = Integer.MAX_VALUE;
        for (int i : basket1) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            minEle = Math.min(minEle, i);
        }
        for (int i : basket2) {
            freq.put(i, freq.getOrDefault(i, 0) - 1);
            minEle = Math.min(minEle, i);
        }

        List<Integer> swappedElements = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swappedElements.add(entry.getKey());
            }
        }

        Collections.sort(swappedElements);
        long res= 0;
        for (int i = 0; i < swappedElements.size() / 2; i++) {
            res += Math.min(2 * minEle, swappedElements.get(i));
        }
        return res;
    }
}
