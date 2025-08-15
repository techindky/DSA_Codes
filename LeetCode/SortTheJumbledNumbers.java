import java.util.*;

class Solution {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        
        Arrays.sort(indices, (a, b) -> {
            long mappedA = getMappedValue(nums[a], mapping);
            long mappedB = getMappedValue(nums[b], mapping);
            if (mappedA != mappedB) return Long.compare(mappedA, mappedB);
            return Integer.compare(a, b);
        });
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }
    
    private static long getMappedValue(int num, int[] mapping) {
        if (num == 0) return mapping[0];
        long mappedValue = 0;
        long place = 1;
        while (num > 0) {
            int digit = num % 10;
            mappedValue += mapping[digit] * place;
            place *= 10;
            num /= 10;
        }
        return mappedValue;
    }
}
