class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        n = len(grid)
        area = 0
        front = side = 0
        for i in range(n):
            front += max(grid[i])
            temp = 0
            for j in range(n):
                if grid[i][j]>0:
                    area+=1
                temp = max(temp, grid[j][i])
            side+=temp
        print(area,front,side)
        return area+front+side
