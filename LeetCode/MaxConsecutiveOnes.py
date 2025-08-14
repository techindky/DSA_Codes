class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxCount = 0
        count = 0
        for i in nums:
            if i==1:
                count+=1
            else:
                maxCount = max(maxCount,count)
                count = 0
        return max(maxCount,count)
