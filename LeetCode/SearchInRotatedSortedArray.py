class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]:
                if nums[low] <= target and target < nums[mid]:
                    high -= 1
                else:
                    low += 1
            else:
                if nums[high] >= target and nums[mid] < target:
                    low += 1
                else:
                    high -= 1
        
        return -1
