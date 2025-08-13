class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        result = set()
        nums.sort()
        n = len(nums)
        if n < 4:
            return []
        elif nums[0]+nums[1]+nums[2]+nums[3] > target:
            return []
        elif nums[n-1]+nums[n-2]+nums[n-3]+nums[n-4] < target:
            return []
        for i in range(len(nums)-3):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1, len(nums)-2):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                x = j + 1
                y = len(nums) - 1
                while x < y:
                    current_sum = nums[i]+nums[j]+nums[x]+nums[y]
                    if current_sum == target:
                        result.add((nums[i],nums[j],nums[x],nums[y]))
                        y -= 1
                        x += 1
                    elif current_sum > target:
                        y -= 1
                    else:
                        x += 1
        return list(result)
