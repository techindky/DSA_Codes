class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        h1 = {}
        for i in s:
            h1[i] = h1.get(i, 0) + 1
        h2 = {}
        for i in t:
            h2[i] = h2.get(i, 0) + 1
        if len(h1) != len(h2):
            return False
        for key in h1.keys():
            if key in h2:
                if h1[key] != h2[key]:
                    return False
            else:
                return False
        return True
