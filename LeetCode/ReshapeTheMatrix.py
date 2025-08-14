class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])
        if n*m != r*c:
            return mat
        result = [[0 for _ in range(c)] for _ in range(r)]
        x = 0
        y = 0
        for i in mat:
            for j in i:
                if y<c-1:
                    result[x][y] = j
                    y += 1
                else:
                    result[x][y] = j
                    x += 1 
                    y = 0
        return result

        return result
