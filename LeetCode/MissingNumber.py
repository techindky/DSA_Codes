class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        d = {}
        for i in range(len(nums)+1):
            d[i] = 0
        for i in nums:
            del d[i]
        for i in d.keys():
            return i
            
