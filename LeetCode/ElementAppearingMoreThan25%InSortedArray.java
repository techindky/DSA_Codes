class Solution {
    public int findSpecialInteger(int[] arr) {
        int t = arr.length / 4;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) cnt++;
            else cnt = 1;
            if (cnt > t) return arr[i];
        }
        return arr.length == 1 ? arr[0] : 0;
    }
}
