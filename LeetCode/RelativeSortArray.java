class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr1) {
            freq.put(i, freq.getOrDefault(i,0) + 1);
        }
        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < freq.get(i); j++) {
                arr1[idx++] = i;
            }
            freq.remove(i);
        }
        int sortIdx = idx;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr1[idx++] = entry.getKey();
            }
        }
        Arrays.sort(arr1, sortIdx, idx);
        return arr1;
    }
}
