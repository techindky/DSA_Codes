class Solution:
    def minSwaps(self, s: str) -> int:
        l = []
        for i in s:
            if i == '[':
                l.append(i)
            else:
                if len(l) > 0:
                    l.pop()
        return (len(l)+1)//2
