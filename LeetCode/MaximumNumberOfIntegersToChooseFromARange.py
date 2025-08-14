class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        bannedSet = set(banned)
        count = 0
        for i in range(1,n+1):
            if i not in bannedSet:
                if maxSum - i >= 0:
                    count += 1
                    maxSum -= i
        return count 
