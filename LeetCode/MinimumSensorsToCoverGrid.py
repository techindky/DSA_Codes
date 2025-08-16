import math
class Solution:
    def minSensors(self, n: int, m: int, k: int) -> int:
        bs = 2 * k + 1
        sr = math.ceil(n / bs)
        sc = math.ceil(m / bs)
        return sr * sc
        
