class Solution:
    def mySqrt(self, x: int) -> int:
        s = 1
        e = x
        ans = 0
        while(s<=e):
            m = (s+e)//2
            if m*m==x:
                return m
            elif m*m<x:
                ans = m
                s = m + 1
            else:
                e = m - 1
        return ans
            
