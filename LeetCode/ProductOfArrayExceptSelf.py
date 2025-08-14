class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        leftProduct = 1
        for i in range(n):
            result[i] = leftProduct
            leftProduct *= nums[i]
        rightProduct = 1
        for i in range(n-1,-1,-1):
            result[i] *= rightProduct
            rightProduct *= nums[i]

        return result
