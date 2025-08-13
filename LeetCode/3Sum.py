class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 3:
            if sum(nums) == 0:
                return [nums]
            else:
                return []
        result = set()
        nums.sort()
        for i in range(len(nums) - 1):
            if i > 0 and nums[i-1]==nums[i]:
                continue
            target = 0 - nums[i]
            x = i + 1
            y = len(nums) - 1
            while x < y:
                if nums[x] + nums[y] == target:
                    result.add((nums[i],nums[x],nums[y]))
                    y -= 1
                elif nums[x] + nums[y] > target:
                    y -= 1
                else:
                    x += 1
        return list(result)
