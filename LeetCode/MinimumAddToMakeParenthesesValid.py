class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        openBrac = 0
        closeBrac = 0
        for i in s:
            if i == '(':
                openBrac += 1
            elif i == ')' and openBrac > 0:
                openBrac -= 1
            else:
                closeBrac += 1
        if openBrac <= 0:
            return closeBrac
        else:
            return openBrac + closeBrac
