class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        h1 = {}
        h2 = {}
        for i in grid:
            s = tuple(i)
            h1[s] = h1.get(s, 0)+1
        for i in range(len(grid)):
            temp = []
            for j in range(len(grid)):
                temp.append(grid[j][i])
            temp = tuple(temp)
            h2[temp] = h2.get(temp, 0) + 1
        ans = 0
        for key in h1.keys():
            if key in h2:
                ans+=h1[key]*h2[key]
        return ans
