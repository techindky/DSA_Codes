import java.util.*;

public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];
        int result = 0;

        while(low<=high) {
            int mid = (low+high) >> 1;
            if(canPlaceCows(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int cows = 1, lastPosition = stalls[0];

        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - lastPosition >= distance) {
                cows++;
                lastPosition = stalls[i];
            }
            if(cows >= k) {
                return true;
            }
        }
        return false;
    }
}