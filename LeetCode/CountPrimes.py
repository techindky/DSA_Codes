class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        marks = [1] * (n // 2)
        max_factor = int(sqrt(n)) + 1
        for i in range(3, max_factor+1, 2):
            if marks[i//2 - 1] == 1:
                marks[i*i//2 -1: n//2 - 1: i] = [0]*((n-1-i*i)//(i*2) + 1)
        return sum(marks)
