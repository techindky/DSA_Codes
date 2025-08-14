class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if s==s[::-1]:
            return s
        for i in range(len(s), 0, -1):
            if s[:i] == s[:i][::-1]:
                l = i
                break
        return s[l:][::-1] + s
