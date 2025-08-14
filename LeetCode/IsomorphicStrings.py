class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dic = {}
        n = len(s)
        for i in range(n):
            if s[i] not in dic:
                if t[i] in dic.values():
                    return False
                dic[s[i]] = t[i]
        for i in range(n):
            if dic[s[i]]!=t[i]:
                return False
        return True
