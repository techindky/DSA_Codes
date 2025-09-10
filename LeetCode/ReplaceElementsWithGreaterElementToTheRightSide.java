class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int max = arr[length-1];
        arr[length-1] = -1;
        for (int i = length - 2; i >= 0; i--) {
            int num = arr[i];
            arr[i] = max;
            if (num > max) max = num;
        }
        return arr;
    }
}
