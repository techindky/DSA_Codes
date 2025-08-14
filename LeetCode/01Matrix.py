from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return []

        rows, cols = len(mat), len(mat[0])
        queue = deque()

        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))
                else:
                    mat[r][c] = float('inf')  

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]  
        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                rr, cc = r + dr, c + dc
                if 0 <= rr < rows and 0 <= cc < cols and mat[rr][cc] == float('inf'):
                    mat[rr][cc] = mat[r][c] + 1
                    queue.append((rr, cc))

        return mat
