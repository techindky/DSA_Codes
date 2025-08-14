class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        ops = 0
        i = 0
        j = len(nums)-1
        while i < j:
            if nums[i]+nums[j] == k:
                ops+=1
                i+=1
                j-=1
            elif nums[i]+nums[j] < k:
                i+=1
            else:
                j-=1
        return ops
