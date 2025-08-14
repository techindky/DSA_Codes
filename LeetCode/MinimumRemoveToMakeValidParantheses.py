class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        chars = list(s)

        # First pass: mark invalid ')' characters
        for i, char in enumerate(chars):
            if char == '(':
                stack.append(i)
            elif char == ')':
                if stack:
                    stack.pop()
                else:
                    chars[i] = ''

        while stack:
            chars[stack.pop()] = ''

        return ''.join(chars)
                
