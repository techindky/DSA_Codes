class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        n = len(s)
        n1 = len(part)
        while(part in s):
            x = s.find(part)
            s = s[0:x]+s[x+n1:n]
        return s
