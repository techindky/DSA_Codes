class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        s = sum(nums)
        remainder = s % p
        if remainder == 0:
            return 0
        prefix_mod_map = {0: -1}
        prefix_sum = 0
        min_length = float('inf')
        for i, num in enumerate(nums):
            prefix_sum = (prefix_sum + num) % p
            required_mod = (prefix_sum - remainder) % p
            if required_mod in prefix_mod_map:
                min_length = min(min_length, i - prefix_mod_map[required_mod])
            prefix_mod_map[prefix_sum] = i
        if min_length == float('inf') and min_length < len(nums):
            return -1
        elif min_length == len(nums):
            return -1
        return min_length
