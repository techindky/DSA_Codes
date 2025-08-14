class Solution:
    def toLowerCase(self, s: str) -> str:
        sb = list(s)
        for i in range(len(sb)):
            if 65 <= ord(sb[i]) <= 90:
                sb[i] = chr(ord(sb[i]) + 32)
        return ''.join(sb)
