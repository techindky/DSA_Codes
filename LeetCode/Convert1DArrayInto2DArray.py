class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        if m*n != len(original):
            return []
        l = []
        idx = 0
        for i in range(m):
            t = []
            for j in range(n):
                t.append(original[idx])
                idx += 1
            l.append(t)
        return l
