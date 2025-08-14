class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        maxLength = 0
        length = 1
        for i in range(1,len(nums)):
            if nums[i] <= nums[i-1]:
                maxLength = max(length, maxLength)
                length = 1
            else:
                length += 1
        return max(length,maxLength)
