class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        diff = start ^ goal
        return bin(diff).count('1')
