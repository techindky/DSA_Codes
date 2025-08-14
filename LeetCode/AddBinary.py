class Solution:
    def addBinary(self, a: str, b: str) -> str:
        first = int(a,2)
        second = int(b,2)
        return str(bin(first+second)).replace("0b","")
