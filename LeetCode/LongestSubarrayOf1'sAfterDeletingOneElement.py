class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        #Approach 1 using sliding window
        i = 0
        k = 1
        for j in range(len(nums)):
            if nums[j] == 0:
                k-=1
            
            if k < 0:
                if nums[i] == 0:
                    k+=1
                i+=1

        return j - i
