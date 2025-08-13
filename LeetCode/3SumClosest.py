class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        absolute_difference = 99999
        closet_sum = 0
        nums.sort()
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            x = i + 1
            y = len(nums) - 1
            while x < y:
                current_sum = nums[i]+nums[x]+nums[y]
                temp = abs(current_sum - target)
                if temp < absolute_difference:
                    absolute_difference = temp
                    closet_sum = nums[i]+nums[x]+nums[y]
                    
                if current_sum > target:
                    y -= 1
                elif current_sum < target:
                    x += 1
                else:
                    return current_sum
        return closet_sum
