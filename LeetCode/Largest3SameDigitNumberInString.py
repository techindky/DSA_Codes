class Solution:
    def largestGoodInteger(self, num: str) -> str:
        max_integer = -1000
        for i in range(len(num)-2):
            if len(set(num[i:i+3])) == 1:
                max_integer = max(max_integer, int(num[i:i+3]))
        
        return "" if max_integer == -1000 else str(max_integer)
