class Solution:
    def isPalindrome(self, s: str) -> bool:
        low = 0
        high = len(s) -1
        s = s.lower()
        while low <= high:
            isLow = s[low].isalnum()
            isHigh = s[high].isalnum()
            if isLow and isHigh:
                if s[low] != s[high]:
                    return False
                low += 1
                high -= 1
            elif isLow:
                high -= 1
            else:
                low += 1
        return True
