class Solution:
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:
        new_grid = [row[:] for row in grid]
        sub_rows = [grid[x+i][y:y+k] for i in range(k)]

        sub_rows = sub_rows[::-1]
        for i in range(k):
            new_grid[x+i][y:y+k] = sub_rows[i]

        return new_grid
