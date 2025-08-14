class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = ""
        n = len(word1)
        m = len(word2)
        i = j = 0
        while(i < n or j < m):
            if i < n:
                result+=word1[i]
            if j < m:
                result+=word2[j]
            i+=1
            j+=1
        return result
