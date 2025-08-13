class Solution:
    def myAtoi(self, s: str) -> int:
        MAX_INT = 2**31 - 1
        MIN_INT = -2**31
        
        # Step 1: Ignore leading whitespace
        s = s.lstrip()
        
        if not s:
            return 0
        
        # Step 2: Determine the sign
        sign = 1
        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        
        # Step 3: Read the integer part
        result = 0
        for char in s:
            if char.isdigit():
                result = result * 10 + int(char)
            else:
                break
        
        # Step 4: Apply the sign
        result *= sign
        
        # Step 5: Handle 32-bit integer overflow
        if result < MIN_INT:
            return MIN_INT
        if result > MAX_INT:
            return MAX_INT
        
        return result
