from typing import List

class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        misplaced_and_value = -1
        is_sorted = True
      
        for i in range(n):
            if nums[i] != i:
                is_sorted = False
                if misplaced_and_value == -1:
                    misplaced_and_value = i
                else:
                    misplaced_and_value &= i
        if is_sorted:
            return 0
        else:
            return misplaced_and_value
