class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d = {}
        for i in nums:
            d[i] = d.get(i, 0)+1
        maxLength = 0
        for i in d.keys():
            if i+1 in d:
                maxLength = max(d[i]+d[i+1], maxLength)

        return maxLength

            
