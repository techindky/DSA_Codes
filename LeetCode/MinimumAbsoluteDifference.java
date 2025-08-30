class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, n = arr.length;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i-1]));
        }
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i-1]) == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }
        return res;
    }
}
