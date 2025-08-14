class Solution:
    def checkRecord(self, s: str) -> bool:
        absent = 0
        cons_late_count = 0
        for i in range(len(s)):
            if s[i] == 'A' and absent < 2:
                absent += 1
            elif s[i] == 'L' and cons_late_count < 3:
                if i > 0 and s[i-1] != 'L':
                    cons_late_count = 0
                cons_late_count += 1
            elif s[i] == 'P':
                continue
            else:
                return False
        if absent >= 2 or cons_late_count >= 3:
            return False
        return True
                    
                
