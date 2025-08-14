class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if len(s)==0:
            return True
        x = 0
        for i in t:
            if i==s[x]:
                x+=1
            if x==len(s):
                return True
        return False
