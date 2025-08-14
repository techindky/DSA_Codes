class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        result = 0
        product = 1
        left = 0
        for i in range(len(nums)):
            product *= nums[i]
            while product >= k:
                product //= nums[left]
                left+=1
            result += i - left + 1
        return result
        
