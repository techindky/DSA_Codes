class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        d = {}
        n = len(nums)
        result = []
        for i in range(1,n+1):
            d[i] = -1
        for i in nums:
            d[i] = 0
        for key,value in d.items():
            if value == -1:
                result.append(key)
        return result
