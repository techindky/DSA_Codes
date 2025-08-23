class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int targetEle = target - numbers[i];
            int s = i + 1;
            int e = numbers.length - 1;
            while (s <= e) {
                int mid = s + (e-s) /2;
                if (numbers[mid] == targetEle) return new int[]{i+1,mid+1};
                else if (numbers[mid] < targetEle) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
