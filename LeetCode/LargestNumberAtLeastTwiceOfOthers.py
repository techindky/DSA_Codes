class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        n = len(nums)
        maxindex = 0
        maxvalue = nums[0]
        
        for i in range(n):
            if nums[i] > maxvalue:
                maxvalue = nums[i]
                maxindex = i
        for i in range(n):
            if i != maxindex and maxvalue < 2 * nums[i]:
                return -1
        return maxindex
