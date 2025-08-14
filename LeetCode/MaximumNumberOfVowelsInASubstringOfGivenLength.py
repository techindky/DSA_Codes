class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        maxVowels = 0
        for i in s[:k]:
            if i in "aeiou":
                maxVowels+=1
        temp = maxVowels
        for i in range(1,len(s)-k+1):
            if s[i-1] in "aeiou":
                temp-=1
            if s[i+k-1] in "aeiou":
                temp+=1
            maxVowels = max(maxVowels, temp)
        return maxVowels
