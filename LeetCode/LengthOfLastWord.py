class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        lengthOfLastWord = 0
        for i in range(len(s)-1,-1,-1):
            if s[i] != ' ':
                lengthOfLastWord += 1
            elif lengthOfLastWord > 0:
                break
        return lengthOfLastWord
