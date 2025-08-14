class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0,0]
        temp = set(nums)
        nums.sort()
        for i in range(n-1):
            if nums[i] == nums[i+1]:
                result[0] = nums[i]
            if i+1 not in temp:
                result[1] = i+1
        if n not in temp:
            result[1] = n
        return result

        
