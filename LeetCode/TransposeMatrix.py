class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        result = [[0 for j in range(len(matrix))] for i in range(len(matrix[0]))]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                result[j][i] = matrix[i][j]
        return result
