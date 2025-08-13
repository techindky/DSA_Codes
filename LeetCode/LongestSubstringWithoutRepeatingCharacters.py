class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_length = 0
        charIndex = {}
        start = 0
        for end,char in enumerate(s):
            if(char in charIndex and charIndex[char]>=start):
                start = charIndex[char] + 1
            charIndex[char] = end
            max_length = max(max_length,end-start+1)
        return max_length
