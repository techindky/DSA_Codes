class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False
        s1 = set(word1)
        s2 = set(word2)
        h1 = {}
        h2 = {}
        for i in word1:
            h1[i] = h1.get(i, 0)+1
        for i in word2:
            h2[i] = h2.get(i, 0)+1
        l1 = list(h1.values())
        l2 = list(h2.values())
        l1.sort()
        l2.sort()
        print(l1,l2)
        if s1==s2:
            if l1==l2:
                return True
            else:
                return False
