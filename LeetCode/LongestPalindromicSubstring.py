class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if n==1:
            return s
        result = ""
        for i in range(n-1):
            for j in range(i,n):
                if s[i:j+1]==s[i:j+1][::-1]:
                    if len(s[i:j+1])>len(result):
                        result = s[i:j+1]
        return result
