class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        max_val = sum(nums[0:k])
        current_sum = max_val

        for i in range(1,(len(nums) - k)+1):
            current_sum = current_sum - nums[i-1] + nums[i+k-1]
            max_val = max(max_val,current_sum)

        return max_val/k
