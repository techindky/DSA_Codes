class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        d = {}
        n = len(score)
        l = score.copy()
        result = []
        score.sort()
        for i in range(n):
            if i<n-3:
                d[score[i]] = str(n-i)
            elif i==n-3:
                d[score[i]] = "Bronze Medal"
            elif i==n-2:
                d[score[i]] = "Silver Medal"
            else:
                d[score[i]] = "Gold Medal"
        for i in l:
            result.append(d[i])
        return result
