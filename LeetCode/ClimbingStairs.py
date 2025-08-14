class Solution:
    def climbStairs(self, n: int) -> int:
        result = 0
        first = 0
        second = 1
        for i in range(n):
            temp = second
            result=(first+second)
            second = first+second
            first=temp
        return result
