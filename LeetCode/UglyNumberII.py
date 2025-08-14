class Solution:
    def nthUglyNumber(self, n: int) -> int:
        uglyNumberSet = {1}
        currentUgly = 1
        for i in range(n):
            currentUgly = min(uglyNumberSet)
            uglyNumberSet.remove(currentUgly)
            uglyNumberSet.add(currentUgly * 2)
            uglyNumberSet.add(currentUgly * 3)
            uglyNumberSet.add(currentUgly * 5)
        return currentUgly
        
