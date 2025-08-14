class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        num1 = -1000
        num2 = -1000
        num3 = -1000
        min1 = 1000
        min2 = 1000
        for i in nums:
            if num1<i:
                num3 = num2
                num2 = num1
                num1 = i
            elif num2<i:
                num3 = num2
                num2 = i
            elif num3<i:
                num3 = i
            if min1>i:
                min2 = min1
                min1 = i
            elif min2>i:
                min2 = i
        return max(num1*num2*num3, min1*min2*num1)
