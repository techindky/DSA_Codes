class Solution:
    def reverseBits(self, n: int) -> int:
        s = bin(n)[2:]
        l = len(s)
        if l<32:
            for i in range(32-l):
                s = "0" + s
        return int(s[::-1], 2)
