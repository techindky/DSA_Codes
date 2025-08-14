class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            for j in range(m):
                if i-1 < 0 or j - 1 < 0:
                    continue
                elif matrix[i][j] == matrix[i-1][j-1]:
                    continue
                else:
                    return False
        return True
