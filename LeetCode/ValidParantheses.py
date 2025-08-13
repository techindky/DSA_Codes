class Solution:
    def isValid(self, s: str) -> bool:
        if len(s)<2:
            return False
        stack = []
        for i in s:
            if i=='{' or i=='[' or i=='(':
                stack.append(i)
            elif len(stack):
                if i=='}' and stack[-1]=='{':
                    stack.pop()
                elif i==']' and stack[-1]=='[':
                    stack.pop()
                elif i==')' and stack[-1]=='(':
                    stack.pop()
                else:
                    return False
            else:
                return False
        if len(stack):
            return False
        return True
