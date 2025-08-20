class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        dp = [0 for _ in range(col+1)]
        ans = 0
        prev = 0
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 1:
                    temp = dp[j+1]
                    dp[j+1] = 1 + min(prev, min(dp[j],dp[j+1]))
                    prev = temp
                    ans += dp[j+1]
                else:
                    dp[j+1] = 0
        return ans
