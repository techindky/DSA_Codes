class Solution:
    def count_steps(self, curr, n):
        steps = 0
        first = curr
        last = curr
        while first<=n:
            steps += min(n+1, last+1) - first
            first *= 10
            last = last * 10 + 9
        return steps
    def findKthNumber(self, n: int, k: int) -> int:
        k -= 1
        curr = 1
        while k > 0:
            steps = self.count_steps(curr, n)
            if steps<=k:
                curr += 1
                k -= steps
            else:
                curr *= 10
                k -= 1
        return curr
