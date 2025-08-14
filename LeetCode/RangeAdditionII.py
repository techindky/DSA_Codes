class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        if not ops:
            return m*n
        minRow = 40000
        minCol = 40000
        for i in ops:
            minRow = min(minRow, i[0])
            minCol = min(minCol, i[1])
        return minRow*minCol        
