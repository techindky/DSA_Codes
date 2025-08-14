class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        l = arr[:]
        l.sort()
        d = {}
        rank = 1
        for i in l:
            if i not in d:
                d[i] = rank
                rank += 1
        result = []
        for i in arr:
            result.append(d[i])
        return result
