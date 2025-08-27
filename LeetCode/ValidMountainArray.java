class Solution {
    public boolean validMountainArray(int[] arr) {
        int peakIndex = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i+1]) {
                peakIndex = i;
            }
        }
        if (peakIndex == -1) return false;
        for (int i = 1; i < arr.length; i++) {
            if (i <= peakIndex && arr[i - 1] >= arr[i]) return false;
            if (i > peakIndex && arr[i] >= arr[i-1]) return false;
        }
        return true;
    }
}
