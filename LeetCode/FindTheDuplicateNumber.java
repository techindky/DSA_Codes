// class Solution {
//     public int findDuplicate(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for (int i : nums) {
//             if (set.contains(i)) return i;
//             set.add(i);
//         }
//         return -1;
//     }
// }

//Approach 2 : Floyd’s Tortoise and Hare cycle detection
class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: meet inside the cycle
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: find entry (duplicate)
        int p1 = 0, p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
