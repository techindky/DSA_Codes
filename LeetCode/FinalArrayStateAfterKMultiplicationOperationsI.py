class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        for _ in range(k):
            minimum = 0
            for i in range(len(nums)):
                if nums[i] < nums[minimum]:
                    minimum = i
            nums[minimum] = nums[minimum] * multiplier
        
        return nums
