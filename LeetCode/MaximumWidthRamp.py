class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        n = len(nums)
        indices = [i for i in range(n)]
        indices.sort(key = lambda i : (nums[i], i))
        minIndex = n
        maxWidth = 0

        for i in indices:
            maxWidth = max(maxWidth, i - minIndex)
            minIndex = min(minIndex, i)

        return maxWidth
